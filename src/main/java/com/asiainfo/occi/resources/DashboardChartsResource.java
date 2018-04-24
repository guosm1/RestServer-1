package com.asiainfo.occi.resources;

import com.asiainfo.occi.bean.CpuResourceResult;
import com.asiainfo.occi.bean.HdfsResult;
import com.asiainfo.occi.bean.MapreduceJobResult;
import com.asiainfo.occi.bean.SparkJobResult;
import com.asiainfo.occi.bean.generated.Bucket___;
import com.asiainfo.occi.bean.generated.Hdfs;
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
  
  public Response cpuResourceTrend(@QueryParam("rangetime") String rangetime, @QueryParam("intrval") String interval){
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
}
