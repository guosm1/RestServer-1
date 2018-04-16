package com.asiainfo.occi.resources;

import io.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asiainfo.occi.bean.MyBean;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Api(value = "/myresource", description = "My general resources test")
public class MyResource {

  /**
   * Method handling HTTP GET requests. The returned object will be sent
   * to the client as "text/plain" media type.
   *
   * @return String that will be returned as a text/plain response.
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getIt() {
    return "Got it!";
  }

  @GET
  @Path("/test")
  @ApiOperation(value = "Get a POJO model")
  @ApiResponses(value = {
    @ApiResponse(code = 400, message = "Invalid ID supplied",
      responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = Boolean.class)),
    @ApiResponse(code = 404, message = "Pet not found")})
  @Produces(MediaType.APPLICATION_JSON)
  public MyBean getTest() {
    return new MyBean("Yu", "30");
  }

}
