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
	public Response getHdfsQuota(@Context HttpServletRequest request) {
		String path = request.getParameter("path");
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
