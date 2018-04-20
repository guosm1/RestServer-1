package com.asiainfo.occi.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.asiainfo.occi.client.AmbariRestClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author zhaoyim
 */

@Path("ambari/yarn")
@Api(value = "/ambari/yarn", description = "Ambari yarn rest")
public class AmbariYarnResource {

  @Inject
  private AmbariRestClient ambariRestClient;

  @GET
  @Path("/cluster/{clusterName}/yarn/queues")
  @ApiOperation(value = "Get yarn queues info")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Get successfully"),
    @ApiResponse(code = 400, message = "Bad request"),
    @ApiResponse(code = 404, message = "Page not found")
  })
  @Produces((MediaType.APPLICATION_JSON + ";charset=utf-8"))
  public Response getYarnQueues(@PathParam("clusterName") String clusterName) {
    return ambariRestClient.yarnQueue(clusterName);
  }

}
