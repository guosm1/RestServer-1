package com.asiainfo.occi.resources;

import com.asiainfo.occi.bean.HdfsResult;
import com.asiainfo.occi.bean.MapreduceJobResult;
import com.asiainfo.occi.bean.generated.Hdfs;
import com.asiainfo.occi.bean.generated.Jobs;
import com.asiainfo.occi.client.EsRestClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("dashboard")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/dashboard", description = "Dashboard chart metric resources")
public class DashboardChartsResource {

  @Autowired
  private EsRestClient esRestClient;

  @GET
  @ApiOperation("Get cluster hdfs quota")
  @ApiResponses(
    @ApiResponse(code = 200, message = "Get successfully")
  )
  @Path("/hdfs")
  public Response hdfsStorage(){
    Hdfs hdfs = esRestClient.hdfsStorage();
    HdfsResult result = new HdfsResult(hdfs.getHits().getHits().get(0).getSource().getTotal(),
      hdfs.getHits().getHits().get(0).getSource().getUsed());
    return Response.ok().entity(result).build();
  }
  
  @GET
  @ApiOperation("Get mapreduce jobs staticstics")
  @ApiResponses(
    @ApiResponse(code = 200, message = "Get successfully")
  )
  @Path("/mapreduce/staticstics")
  public Response mapreducejobsStatistics(){
    Jobs mr = esRestClient.mapreducejobsStatistics();
    MapreduceJobResult result = new MapreduceJobResult(mr.getCount());
   return Response.ok().entity(result).build();
  }
}
