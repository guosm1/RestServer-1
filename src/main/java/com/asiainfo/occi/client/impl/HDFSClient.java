package com.asiainfo.occi.client.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.ContentSummary;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.log4j.Logger;

/**
 * New HDFS client supports for multi-clusters.
 * @author Ethan
 *
 */
public class HDFSClient{
	private static final Logger LOG = Logger.getLogger(HDFSClient.class);
	private FileSystem fs;
	private static HDFSClient instance;
	private String principal;
	private String keytab;
	private boolean isSecurity = false;

	public static HDFSClient getInstance() {
		if (instance == null) {
			synchronized(HDFSClient.class) {
				if (instance == null) {
					instance = new HDFSClient();
				}
			}
		}
		return instance;
	}
	private HDFSClient() {
		try {
			init();
		} catch (Exception e) {
			LOG.error("Exception while init FS: ", e);
			throw new RuntimeException("Exception while init FS: ", e);
		}
	}
	
	private void login() {
		try {
			if (!isSecurity) {
				return;
			}
			UserGroupInformation.loginUserFromKeytab(principal, keytab);
		} catch (IOException e) {
			LOG.error("Exception while login user: " + principal, e);
			throw new RuntimeException("Exception while login user: " + principal, e);
		}
	}

	private void init() throws Exception {
		fs = FileSystem.get(initHDFSCommon(com.asiainfo.occi.configuration.Configuration.getInstance().hdfs()));
	}

	private Configuration initHDFSCommon(Properties props) {
		LOG.info("HDFS client config: " + props);
		Configuration conf = new Configuration();
		for (Entry<Object, Object> p : props.entrySet()) {
			conf.set(String.valueOf(p.getKey()), String.valueOf(p.getValue()));
		}
		checkKrb(conf);
		return conf;
	}
	
	private void checkKrb(Configuration conf) {
		String m = conf.get("hadoop.security.authentication");
		if (m != null && m.equalsIgnoreCase("kerberos")) {
			String krb5 = conf.get("krb5.file");
			principal = conf.get("principal");
			keytab = conf.get("keytab");
			checkFile(krb5, keytab);
			System.setProperty("java.security.krb5.conf", krb5);
			LOG.info("krb5 file set to path: " + krb5);
			LOG.info("Using principal and keytab for hdfs client: " + principal + ", " + keytab);
			isSecurity = true;
		}
		
	}
	private void checkFile(String... files) {
		for (String file : files) {
			if (!new File(file).exists()) {
				LOG.error("krb.conf file not found: " + file);
				throw new RuntimeException("krb.conf file not found: " + file);
			}
		}
	}
	public long getTotalStorage(String path) {
		try {
			login();
			ContentSummary summary = fs.getContentSummary(new Path(path));
			return summary.getSpaceQuota();
		} catch (Exception e) {
			LOG.error("Exception while get storage of path: " + path);
			throw new RuntimeException("Exception while get storage of path: " + path);
		}
	}
	
	public long getTotalNamespace(String path) {
		try {
			login();
			ContentSummary summary = this.fs.getContentSummary(new Path(path));
			return summary.getQuota();
		} catch (Exception e) {
			LOG.error("Error while get namespace quota by : " + path, e);
			throw new RuntimeException(e);
		}
	}
	
	public long getUsedNamespace(String path) {
		try {
			login();
			ContentSummary summary = this.fs.getContentSummary(new Path(path));
			return summary.getFileCount();
		} catch (Exception e) {
			LOG.error("Error while get namespace quota by : " + path, e);
			throw new RuntimeException(e);
		}
	}
	
	public long getUsedStorge(String path) {
		try {
			login();
			ContentSummary summary = fs.getContentSummary(new Path(path));
			return summary.getSpaceConsumed();
		} catch (Exception e) {
			LOG.error("Exception while get storage of path: " + path);
			throw new RuntimeException("Exception while get storage of path: " + path);
		}
	}
	
	public static void main(String[] args) {
		FileSystem filesys = new HDFSClient().fs;
		try {
			FileStatus[] files = filesys.listStatus(new Path("/"));
			for (FileStatus file : files) {
				System.out.println(">>> " + file);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of main");
	}

}
