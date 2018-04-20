package com.asiainfo.occi.client.impl;

import com.asiainfo.occi.bean.generated.Hdfs;
import com.asiainfo.occi.bean.generated.Jobs;
import com.asiainfo.occi.client.EsRestClient;
import com.asiainfo.occi.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EsRestClientImpl implements EsRestClient{
  private final static Logger logger = LoggerFactory.getLogger(EsRestClientImpl.class);
  private static WebTarget webTarget;
  private final static Configuration configuration = Configuration.getInstance();
  private final static String logstash_disk = "/logstash-disk/";
  private final static String mylogstash_yarn_apps = "/mylogstash-yarn-apps/";

  public EsRestClientImpl(){
    Client client = ClientBuilder.newClient();
    String restServer = configuration.esRestServer();
    webTarget = client.target(restServer);
  }

  @Override
  public Hdfs hdfsStorage() {
    WebTarget resourceWebTarget = webTarget.path(logstash_disk + "disk/_search");
    Invocation.Builder request = resourceWebTarget.request();
    Response post = request.post(Entity.entity("{\"query\":{\"match_all\":{}},\"sort\":[{\"@timestamp\":{\"order\":\"desc\"}}],\"size\":1,\"_source\":{\"include\":[\"total\",\"used\",\"@timestamp\"]}}",
      MediaType.APPLICATION_JSON));
    Hdfs result = null;
    if(post.getStatus() == 200) {
      result = post.readEntity(Hdfs.class);
      logger.info("Total " + result.getHits().getHits().get(0).getSource().getTotal().toString());
    }
    return result;
  }
  
  public Jobs mapreducejobsStatistics() {
	    WebTarget resourceWebTarget = webTarget.path(mylogstash_yarn_apps + "yarn.apps/_count");
      Invocation.Builder request = resourceWebTarget.queryParam("q", "appType:MAPREDUCE").request();
	    Response get = request.get();
	    Jobs result = get.readEntity(Jobs.class);
	    logger.info("count " + result.getCount().toString());
	    return result;
	  }

  public Jobs sparkjobsStatistics(){
    WebTarget resourceWebTarget = webTarget.path(mylogstash_yarn_apps + "yarn.apps/_count");
    Invocation.Builder request = resourceWebTarget.queryParam("q", "appType:SPARK").request();
    Response get = request.get();
    Jobs result = get.readEntity(Jobs.class);
    logger.info("count " + result.getCount().toString());
    return result;
  }
  

}
