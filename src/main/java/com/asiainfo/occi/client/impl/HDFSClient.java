package com.asiainfo.occi.client.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.ContentSummary;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;

import com.asiainfo.ocmanager.utils.ServerConfiguration;

/**
 * New HDFS client supports for multi-clusters.
 * @author Ethan
 *
 */
public class HDFSClient{
	private static final Logger LOG = Logger.getLogger(HDFSClient.class);
	private FileSystem fs;
	private static HDFSClient instance;

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

	private void init() throws Exception {
		fs = FileSystem.get(initHDFSCommon(com.asiainfo.occi.configuration.Configuration.getInstance().hdfs()));
	}

	private Configuration initHDFSCommon(Properties props) {
		Configuration conf = new Configuration();
		for (Entry<Object, Object> p : props.entrySet()) {
			conf.set(String.valueOf(p.getKey()), String.valueOf(p.getValue()));
		}
		return conf;
	}
	
	public long getTotalStorage(String path) {
		try {
			ContentSummary summary = fs.getContentSummary(new Path(path));
			return summary.getSpaceQuota();
		} catch (Exception e) {
			LOG.error("Exception while get storage of path: " + path);
			throw new RuntimeException("Exception while get storage of path: " + path);
		}
	}
	
	public long getTotalNamespace(String path) {
		try {
			ContentSummary summary = this.fs.getContentSummary(new Path(path));
			return summary.getQuota();
		} catch (Exception e) {
			LOG.error("Error while get namespace quota by : " + path, e);
			throw new RuntimeException(e);
		}
	}
	
	public long getUsedNamespace(String path) {
		try {
			ContentSummary summary = this.fs.getContentSummary(new Path(path));
			return summary.getFileCount();
		} catch (Exception e) {
			LOG.error("Error while get namespace quota by : " + path, e);
			throw new RuntimeException(e);
		}
	}
	
	public long getUsedStorge(String path) {
		try {
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
