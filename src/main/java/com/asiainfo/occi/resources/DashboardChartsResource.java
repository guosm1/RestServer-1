package com.asiainfo.occi.resources;

import com.asiainfo.occi.bean.*;
import com.asiainfo.occi.bean.JobTrendResult.Pod;
import com.asiainfo.occi.bean.generated.Bucket_;
import com.asiainfo.occi.bean.generated.Bucket___;
import com.asiainfo.occi.bean.generated.Hdfs;
import com.asiainfo.occi.bean.generated.JobTrend;
import com.asiainfo.occi.bean.generated.Jobs;
import com.asiainfo.occi.bean.generated.Resource;
import com.asiainfo.occi.client.EsRestClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("dashboard")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/dashboard", description = "Dashboard chart metric resources")
public class DashboardChartsResource {

  @Inject
  private EsRestClient esRestClient;

  @GET
  @ApiOperation("Get cluster hdfs quota")
  @ApiResponses({
    @ApiResponse(code = 200, message = "Get successfully"),
    @ApiResponse(code = 404, message = "Cannot get hdfs quota")
  })
  @Path("/hdfs/quota")
  public Response hdfsStorage(){
    Hdfs hdfs = esRestClient.hdfsStorage();
    if(null == hdfs) {
      return Response.status(404).entity("{\"status\": 404, \"message\": \"Cannot get hdfs quota\"}").build();
    }else{
      HdfsResult result = new HdfsResult(hdfs.getHits().getHits().get(0).getSource().getTotal(),
        hdfs.getHits().getHits().get(0).getSource().getUsed());
      return Response.ok().entity(result).build();
    }
  }
  
  @GET
  @ApiOperation("Get mapreduce jobs statistics")
  @ApiResponses({
	    @ApiResponse(code = 200, message = "Get successfully"),
	    @ApiResponse(code = 404, message = "Cannot get hdfs quota")
	  })
  @Path("/mapreduce/staticstics")
  public Response mapreducejobsStatistics(){
    Jobs mr = esRestClient.mapreducejobsStatistics();
    if (null == mr) {
    	return Response.status(404).entity("{\"status\": 404, \"message\": \"Cannot get mapreduce jobs statistics\"}").build();	
	} else {
		MapreduceJobResult result = new MapreduceJobResult(mr.getCount());
		   return Response.ok().entity(result).build();
	}
  }

  @GET
  @ApiOperation("Get spark jobs statistics")
  @ApiResponses(
    @ApiResponse(code = 200, message = "Get successfully")
  )
  @Path("/spark/staticstics")
  public Response sparkjobsStatistics(){
    Jobs spark = esRestClient.sparkjobsStatistics();
    SparkJobResult result = new SparkJobResult(spark.getCount());
    return Response.ok().entity(result).build();
  }
  
  @GET
  @ApiOperation("Get cpu resource trend")
  @ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Get successfully"),
			@ApiResponse(code = 404, message = "Page not found") })
  @Path("/resource/cpu_trend")
  
  public Response cpuResourceTrend(@QueryParam("rangetime") String rangetime, @QueryParam("interval") String interval){
      Resource cpu = esRestClient.cpuResourceTrend(rangetime, interval);
      if (cpu == null) {
    	  return Response.status(404).entity("{\"status\": 404, \"message\": \"Cannot Get cpu resource trend\"}").build();
	} else {
		List<CpuResourceResult.Pod> pod = new ArrayList<>();
	      List<Bucket___> list = cpu.getAggregations().getRangeLogdate().getBuckets().get(0).getHistogramLogdate().getBuckets();
	    	  list.forEach(e -> {
	    		 Double vcore = e.getAvgVCores().getValue();
	    		 Double key = e.getKey();
	    		 pod.add(new CpuResourceResult.Pod(vcore, key));
	      });
	      CpuResourceResult result = new CpuResourceResult(pod);
		  return Response.ok().entity(result).build();
	}    
  }
  
  @GET
  @ApiOperation("Get memory resource trend")
  @ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Get successfully"),
			@ApiResponse(code = 404, message = "Page not found") })
  @Path("/resource/memory_trend")
  
  public Response memoryRecourceTrend(@QueryParam("rangetime") String rangetime, @QueryParam("interval") String interval){
      Resource mem = esRestClient.memoryRecourceTrend(rangetime, interval);
      if (mem == null) {
    	  return Response.status(404).entity("{\"status\": 404, \"message\": \"Cannot Get memory resource trend\"}").build();
	} else {
		  List<MemoryResourceResult.Pod> pod = new ArrayList<>();
	      List<Bucket___> list = mem.getAggregations().getRangeLogdate().getBuckets().get(0).getHistogramLogdate().getBuckets();
	    	  list.forEach(e -> {
	    		 Double memory = e.getAvgMemory().getValue();
	    		 Double time = e.getKey();
	    		 pod.add(new MemoryResourceResult.Pod(memory, time));
	      });
	    	  MemoryResourceResult result = new MemoryResourceResult(pod);
		  return Response.ok().entity(result).build();
	}    
  }
  
  @GET
  @ApiOperation("Get mapreduce jobs trend")
  @ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Get successfully"),
			@ApiResponse(code = 404, message = "Page not found") })
  @Path("/jobs_trend/mapreduce")
  
  public Response mapreduceTrend(@QueryParam("rangetime") String rangetime, @QueryParam("interval") String interval){
      JobTrend mrtrend = esRestClient.mapreduceTrend(rangetime, interval);
      if (mrtrend == null) {
    	  return Response.status(404).entity("{\"status\": 404, \"message\": \"Cannot Get mapreduce jobs trend\"}").build();
    } else {
    	List<Pod> pods = new ArrayList<>();
    	List<Bucket_> list = mrtrend.getAggregations().getRangeFinishedTime().getBuckets().get(0).getHistogramFinishedTime().getBuckets();
    	list.forEach(e -> {
    		Double mr_count =e.getDocCount();
    		Double time = e.getKey();
    		pods.add(new Pod(mr_count, time));
    		});
    	JobTrendResult result = new JobTrendResult(pods);
    	return Response.ok().entity(result).build();
    	}
  }
  
  @GET
  @ApiOperation("Get spark jobs trend")
  @ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Get successfully"),
			@ApiResponse(code = 404, message = "Page not found") })
  @Path("/jobs_trend/spark")
  
  public Response sparkTrend(@QueryParam("rangetime") String rangetime, @QueryParam("interval") String interval){
      JobTrend sparktrend = esRestClient.sparkTrend(rangetime, interval);
      if (sparktrend == null) {
    	  return Response.status(404).entity("{\"status\": 404, \"message\": \"Cannot Get spark jobs trend\"}").build();
    } else {
    	List<Pod> pods = new ArrayList<>();
    	List<Bucket_> list = sparktrend.getAggregations().getRangeFinishedTime().getBuckets().get(0).getHistogramFinishedTime().getBuckets();
    	list.forEach(e -> {
    		Double spark_count =e.getDocCount();
    		Double time = e.getKey();
    		pods.add(new Pod(spark_count, time));
    		});
		JobTrendResult result = new JobTrendResult(pods);
	    	return Response.ok().entity(result).build(); 
    	}
  }   	
}
