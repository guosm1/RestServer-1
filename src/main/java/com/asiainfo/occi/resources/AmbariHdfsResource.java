package com.asiainfo.occi.resources;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.asiainfo.occi.client.AmbariRestClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

/**
 * @author zhaoyim
 */

@Path("ambari/hdfs")
@Api(value = "/ambari/hdfs", description = "Ambari hdfs rest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AmbariHdfsResource {

  @Inject
  private AmbariRestClient ambariRestClient;

  @GET
  @Path("/cluster/{clusterName}/hdfs/namenode")
  @ApiOperation(value = "Get hdfs namenode info")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Get successfully"),
    @ApiResponse(code = 400, message = "Bad request"),
    @ApiResponse(code = 404, message = "Page not found")
  })
  public Response getNameNodeInfo(@PathParam("clusterName") String clusterName) {
    return ambariRestClient.nameNodeInfo(clusterName);
  }

  @GET
  @Path("/cluster/{clusterName}/hdfs/datanode")
  @ApiOperation(value = "Get hdfs datanode info")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Get successfully"),
    @ApiResponse(code = 400, message = "Bad request"),
    @ApiResponse(code = 404, message = "Page not found")
  })
  public Response getDataNodeInfo(@PathParam("clusterName") String clusterName) {
    return ambariRestClient.dataNodeInfo(clusterName);
  }

}
