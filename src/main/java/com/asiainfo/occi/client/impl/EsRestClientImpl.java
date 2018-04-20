package com.asiainfo.occi.client.impl;

import com.asiainfo.occi.bean.generated.Hdfs;
import com.asiainfo.occi.bean.generated.Jobs;
import com.asiainfo.occi.bean.generated.Resource;
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
  private final static String mylogstash_yarn_running = "/mylogstash-yarn-running/";

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
    WebTarget resourceWebTarget = webTarget.path(mylogstash_yarn_running + "yarn.apps/_count");
    Invocation.Builder request = resourceWebTarget.queryParam("q", "appType:SPARK").request();
    Response get = request.get();
    Jobs result = get.readEntity(Jobs.class);
    logger.info("count " + result.getCount().toString());
    return result;
  }

@Override
public Resource cpuResourceTrend() {
	// TODO Auto-generated method stub
	WebTarget resourceWeTarget = webTarget.path(mylogstash_yarn_running + "_search");
	Invocation.Builder request = resourceWeTarget.queryParam("search_type", "count").request();
	Response post = request.post(Entity.entity("{\"aggs\":{\"range_logdate\":{\"date_range\":{\"field\":\"logdate\",\"format\":\"epoch_millis\",\"ranges\":[{\"from\":\"now-1d\",\"to\":\"now\"}]},\"aggs\":{\"histogram_logdate\":{\"date_histogram\":{\"field\":\"logdate\",\"interval\":\"5m\",\"time_zone\":\"Asia/Shanghai\",\"format\":\"yyyy-MM-dd HH:mm:ss\",\"min_doc_count\":0},\"aggs\":{\"avg_vCores\":{\"avg\":{\"field\":\"vCores\"}}}}}}}}", MediaType.APPLICATION_JSON));
	Resource result = post.readEntity(Resource.class);
	logger.info("value" + result.getAggregations().getRangeLogdate().getBuckets().get(0).getHistogramLogdate().getBuckets().get(0).getAvgVCores().getValue().toString());
	logger.info("timestamp" + result.getAggregations().getRangeLogdate().getBuckets().get(0).getHistogramLogdate().getBuckets().get(0).getKey().toString());
	return result;
}
  
  
  

}
