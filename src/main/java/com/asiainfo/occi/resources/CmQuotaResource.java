package com.asiainfo.occi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

/**
 * 
 * @author zhaoyim
 *
 */

@Path("cm/quota")
@Api(value = "/cm/quota", description = "Cluster Manager quota rest")
public class CmQuotaResource {

	@GET
	@Path("/cluster/{clusterName}/hdfs")
	@ApiOperation(value = "Get hdfs quota info")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad request", responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = Boolean.class)),
			@ApiResponse(code = 404, message = "Page not found") })
	@Produces((MediaType.APPLICATION_JSON + ";charset=utf-8"))
	public Response getHdfsQuota() {
		// http://10.1.236.60:9090/ocmanager/v1/api/quota/hdfs?service=hdfs&path=/hdfscluster1
		return Response.ok().entity("{"+
			  "\"items\": [{"+
				    "\"available\": \"1\","+
				    "\"name\": \"nameSpaceQuota\","+
				    "\"resource\": \"/hdfscluster1\","+
				    "\"size\": \"1\","+
				    "\"used\": \"0\""+
				  "}, {"+
				    "\"available\": \"1000000000\","+
				    "\"name\": \"storageSpaceQuota\","+
				    "\"resource\": \"/hdfscluster1\","+
				    "\"size\": \"1000000000\","+
				    "\"used\": \"0\""+
				  "}]"+
				"}").build();
	}
		


}
