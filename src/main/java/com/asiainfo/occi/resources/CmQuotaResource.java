package com.asiainfo.occi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.asiainfo.occi.client.impl.HDFSClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	@Produces((MediaType.APPLICATION_JSON + ";charset=utf-8"))
	@ApiOperation(value = "Get hdfs resource quota")
		@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Get successfully"),
	    @ApiResponse(code = 400, message = "Bad request"),
	    @ApiResponse(code = 404, message = "Page not found")
	})
	public Response getHdfsQuota(@PathParam("path") String path) {
		long storage = HDFSClient.getInstance().getTotalStorage(path);
		long namespace = HDFSClient.getInstance().getTotalNamespace(path);
		long usedStorage = HDFSClient.getInstance().getUsedStorge(path);
		long usedNs = HDFSClient.getInstance().getUsedNamespace(path);
		return Response.ok().entity("{" + "\"items\": [{" + "\"available\": \"xxx\"," + "\"name\": \"nameSpaceQuota\","
				+ "\"resource\": \"" + path + "\"," + "\"size\": \"" + namespace + "\"," + "\"used\": \"" + usedNs
				+ "\"" + "}, {" + "\"available\": \"xxx\"," + "\"name\": \"storageSpaceQuota\"," + "\"resource\": \""
				+ path + "\"," + "\"size\": \"" + storage + "\"," + "\"used\": \"" + usedStorage + "\"" + "}]" + "}")
				.build();
	}

}
