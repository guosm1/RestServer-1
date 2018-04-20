package com.asiainfo.occi.client.impl;

import com.asiainfo.occi.client.AmbariRestClient;
import com.asiainfo.occi.configuration.Configuration;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Map;

public class AmbariRestClientImpl implements AmbariRestClient{
  private final static Logger logger = LoggerFactory.getLogger(AmbariRestClientImpl.class);
  private static WebTarget webTarget;
  private final static Configuration configuration = Configuration.getInstance();
  private final static String prefix = "/api/v1/";

  public AmbariRestClientImpl(){
    Map<String, String> info = configuration.ambariRestServer();
    Client client = ClientBuilder.newClient();
    webTarget = client.target(info.get("url"));
    webTarget.register(HttpAuthenticationFeature.basicBuilder().credentials(info.get("username"), info.get("password")).build());
  }


  @Override
  public Response dataNodeInfo(String clusterName) {
    WebTarget resourceWebTarget = webTarget.path(prefix + "clusters/" + clusterName + "/services/HDFS/components/DATANODE");
    Invocation.Builder request = resourceWebTarget.queryParam("fields", "ServiceComponentInfo,metrics/dfs/datanode/NumFailedVolumes,metrics/dfs/datanode/DfsUsed,metrics/dfs/datanode/Capacity").request();
    Response get = request.get();
    logger.info(String.valueOf(get.getStatus()));
    return get;
  }

  @Override
  public Response nameNodeInfo(String clusterName) {
    WebTarget resourceWebTarget = webTarget.path(prefix + "clusters/" + clusterName + "/services/HDFS/components/NAMENODE");
    Invocation.Builder request = resourceWebTarget.queryParam("fields", "ServiceComponentInfo").request();
    Response get = request.get();
    logger.info(String.valueOf(get.getStatus()));
    return get;
  }

  @Override
  public Response hostInfo(String clusterName) {
    WebTarget resourceWebTarget = webTarget.path(prefix + "clusters/" + clusterName + "/hosts");
    Invocation.Builder request = resourceWebTarget.queryParam("fields", "metrics/disk/disk_free").request();
    Response get = request.get();
    logger.info(String.valueOf(get.getStatus()));
    return get;
  }

  @Override
  public Response yarnQueue(String clusterName) {
    WebTarget resourceWebTarget = webTarget.path(prefix + "clusters/" + clusterName + "/services/YARN/components/RESOURCEMANAGER");
    Invocation.Builder request = resourceWebTarget.queryParam("fields", "metrics/yarn/Queue").request();
    Response get = request.get();
    logger.info(String.valueOf(get.getStatus()));
    return get;
  }
}
