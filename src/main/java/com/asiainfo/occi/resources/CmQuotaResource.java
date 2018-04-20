package com.asiainfo.occi.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.asiainfo.occi.client.impl.HDFSClient;

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
	@Path("/hdfs")
	@ApiOperation(value = "Get hdfs quota info")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad request", responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = Boolean.class)),
			@ApiResponse(code = 404, message = "Page not found") })
	@Produces((MediaType.APPLICATION_JSON + ";charset=utf-8"))
	public Response getHdfsQuota(@Context HttpServletRequest request) {
		String path = request.getParameter("path");
		long storage = HDFSClient.getInstance().getTotalStorage(path);
		long namespace = HDFSClient.getInstance().getTotalNamespace(path);
		long usedStorage = HDFSClient.getInstance().getUsedStorge(path);
		long usedNs = HDFSClient.getInstance().getUsedNamespace(path);
		return Response.ok().entity("{"+
			  "\"items\": [{"+
				    "\"available\": \"xxx\","+
				    "\"name\": \"nameSpaceQuota\","+
				    "\"resource\": \"" + path+ "\"," +
				    "\"size\": \"" + namespace +"\","+
				    "\"used\": \"" + usedNs + "\"" +
				  "}, {"+
				    "\"available\": \"xxx\","+
				    "\"name\": \"storageSpaceQuota\","+
				    "\"resource\": \"" + path + "\","+
				    "\"size\": \"" + storage +"\","+
				    "\"used\": \"" + usedStorage +"\""+
				  "}]"+
				"}").build();
	}
		


}
