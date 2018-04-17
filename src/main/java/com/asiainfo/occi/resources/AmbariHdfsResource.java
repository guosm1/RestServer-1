package com.asiainfo.occi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

@Path("ambari/hdfs")
@Api(value = "/ambari/hdfs", description = "Ambari hdfs rest")
public class AmbariHdfsResource {

	@GET
	@Path("/cluster/{clusterName}/hdfs/namenode")
	@ApiOperation(value = "Get hdfs namenode info")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad request", responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = Boolean.class)),
			@ApiResponse(code = 404, message = "Page not found") })
	@Produces((MediaType.APPLICATION_JSON + ";charset=utf-8"))
	public Response getNameNodeInfo(@PathParam("clusterName") String clusterName) {
		//http://10.1.236.61:8080/api/v1/clusters/testcluster/services/HDFS/components/NAMENODE?fields=ServiceComponentInfo
		return Response.ok().entity("{"+
			  "\"href\" : \"http://10.1.236.61:8080/api/v1/clusters/testcluster/services/HDFS/components/NAMENODE?fields=ServiceComponentInfo\","+
			  "\"ServiceComponentInfo\" : {"+
			    "\"CapacityRemaining\" : 1229897213924,"+
			    "\"CapacityTotal\" : 1386639163392,"+
			    "\"CapacityUsed\" : 73986838528,"+
			    "\"DeadNodes\" : \"{}\","+
			    "\"DecomNodes\" : \"{}\","+
			    "\"HeapMemoryMax\" : 1060372480,"+
			    "\"HeapMemoryUsed\" : 306182792,"+
			    "\"LiveNodes\" : \"{\\\"xiaomm.jcloud.local:50010\\\":{\\\"infoAddr\\\":\\\"10.1.236.61:50075\\\",\\\"infoSecureAddr\\\":\\\"10.1.236.61:0\\\",\\\"xferaddr\\\":\\\"10.1.236.61:50010\\\",\\\"lastContact\\\":1,\\\"usedSpace\\\":24662581248,\\\"adminState\\\":\\\"In Service\\\",\\\"nonDfsUsedSpace\\\":0,\\\"capacity\\\":462213054464,\\\"numBlocks\\\":12562,\\\"version\\\":\\\"2.7.3.2.6.0.3-8\\\",\\\"used\\\":24662581248,\\\"remaining\\\":409965436236,\\\"blockScheduled\\\":0,\\\"blockPoolUsed\\\":24662581248,\\\"blockPoolUsedPercent\\\":5.3357606,\\\"volfails\\\":0},\\\"ochadoop112.jcloud.local:50010\\\":{\\\"infoAddr\\\":\\\"10.1.236.112:50075\\\",\\\"infoSecureAddr\\\":\\\"10.1.236.112:0\\\",\\\"xferaddr\\\":\\\"10.1.236.112:50010\\\",\\\"lastContact\\\":2,\\\"usedSpace\\\":24661884928,\\\"adminState\\\":\\\"In Service\\\",\\\"nonDfsUsedSpace\\\":0,\\\"capacity\\\":462213054464,\\\"numBlocks\\\":12562,\\\"version\\\":\\\"2.7.3.2.6.0.3-8\\\",\\\"used\\\":24661884928,\\\"remaining\\\":409966132556,\\\"blockScheduled\\\":0,\\\"blockPoolUsed\\\":24661884928,\\\"blockPoolUsedPercent\\\":5.3356094,\\\"volfails\\\":0},\\\"ochadoop111.jcloud.local:50010\\\":{\\\"infoAddr\\\":\\\"10.1.236.111:50075\\\",\\\"infoSecureAddr\\\":\\\"10.1.236.111:0\\\",\\\"xferaddr\\\":\\\"10.1.236.111:50010\\\",\\\"lastContact\\\":0,\\\"usedSpace\\\":24662372352,\\\"adminState\\\":\\\"In Service\\\",\\\"nonDfsUsedSpace\\\":0,\\\"capacity\\\":462213054464,\\\"numBlocks\\\":12562,\\\"version\\\":\\\"2.7.3.2.6.0.3-8\\\",\\\"used\\\":24662372352,\\\"remaining\\\":409965645132,\\\"blockScheduled\\\":0,\\\"blockPoolUsed\\\":24662372352,\\\"blockPoolUsedPercent\\\":5.335715,\\\"volfails\\\":0}}\","+
			    "\"NonDfsUsedSpace\" : 0,"+
			    "\"NonHeapMemoryMax\" : -1,"+
			    "\"NonHeapMemoryUsed\" : 115491384,"+
			    "\"PercentRemaining\" : 88.69627,"+
			    "\"PercentUsed\" : 5.3356953,"+
			    "\"Safemode\" : \"\","+
			    "\"StartTime\" : 1522377639386,"+
			    "\"TotalFiles\" : 24961,"+
			    "\"UpgradeFinalized\" : true,"+
			    "\"Version\" : \"2.7.3.2.6.0.3-8, rc6befa0f1e911140cc815e0bab744a6517abddae\","+
			    "\"category\" : \"MASTER\","+
			    "\"cluster_name\" : \"testcluster\","+
			    "\"component_name\" : \"NAMENODE\","+
			    "\"display_name\" : \"NameNode\","+
			    "\"init_count\" : 0,"+
			    "\"install_failed_count\" : 0,"+
			    "\"installed_count\" : 0,"+
			    "\"recovery_enabled\" : \"false\","+
			    "\"service_name\" : \"HDFS\","+
			    "\"started_count\" : 1,"+
			    "\"state\" : \"STARTED\","+
			    "\"total_count\" : 1,"+
			    "\"unknown_count\" : 0"+
			  "}"+
			"}").build();

	}

	@GET
	@Path("/cluster/{clusterName}/hdfs/datanode")
	@ApiOperation(value = "Get hdfs datanode info")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad request", responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = Boolean.class)),
			@ApiResponse(code = 404, message = "Page not found") })
	@Produces((MediaType.APPLICATION_JSON + ";charset=utf-8"))
	public Response getDataNodeInfo(@PathParam("clusterName") String clusterName) {
		//http://10.1.236.61:8080/api/v1/clusters/testcluster/services/HDFS/components/DATANODE/?fields=ServiceComponentInfo,metrics/dfs/datanode/NumFailedVolumes,metrics/dfs/datanode/DfsUsed,metrics/dfs/datanode/Capacity
		return Response.ok().entity("{"+
			  "\"href\" : \"http://10.1.236.61:8080/api/v1/clusters/testcluster/services/HDFS/components/DATANODE/?fields=ServiceComponentInfo,metrics/dfs/datanode/NumFailedVolumes,metrics/dfs/datanode/DfsUsed,metrics/dfs/datanode/Capacity\","+
			  "\"ServiceComponentInfo\" : {"+
			    "\"category\" : \"SLAVE\","+
			    "\"cluster_name\" : \"testcluster\","+
			    "\"component_name\" : \"DATANODE\","+
			    "\"display_name\" : \"DataNode\","+
			    "\"init_count\" : 0,"+
			    "\"install_failed_count\" : 0,"+
			    "\"installed_count\" : 0,"+
			    "\"recovery_enabled\" : \"false\","+
			    "\"service_name\" : \"HDFS\","+
			    "\"started_count\" : 3,"+
			    "\"state\" : \"STARTED\","+
			    "\"total_count\" : 3,"+
			    "\"unknown_count\" : 0"+
			  "},"+
			  "\"metrics\" : {"+
			    "\"dfs\" : {"+
			      "\"datanode\" : {"+
			        "\"Capacity\" : 4.62213054464E11,"+
			        "\"DfsUsed\" : 2.4672163157333332E10,"+
			        "\"NumFailedVolumes\" : 0.0"+
			      "}"+
			    "}"+
			  "}"+
			"}").build();

	}

}
