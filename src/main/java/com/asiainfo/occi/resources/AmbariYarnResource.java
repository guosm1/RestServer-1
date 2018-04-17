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

@Path("ambari/yarn")
@Api(value = "/ambari/yarn", description = "Ambari yarn rest")
public class AmbariYarnResource {

	
	@GET
	@Path("/cluster/{clusterName}/yarn/queues")
	@ApiOperation(value = "Get yarn queues info")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad request", responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = Boolean.class)),
			@ApiResponse(code = 404, message = "Page not found") })
	@Produces((MediaType.APPLICATION_JSON + ";charset=utf-8"))
	public Response getYarnQueues(@PathParam("clusterName") String clusterName) {
		//http://10.1.236.61:8080/api/v1/clusters/testcluster/services/YARN/components/RESOURCEMANAGER?fields=metrics/yarn/Queue
		return Response.ok().entity("{"+
			  "\"href\" : \"http://10.1.236.61:8080/api/v1/clusters/testcluster/services/YARN/components/RESOURCEMANAGER?fields=metrics/yarn/Queue\","+
			  "\"ServiceComponentInfo\" : {"+
			    "\"cluster_name\" : \"testcluster\","+
			    "\"component_name\" : \"RESOURCEMANAGER\","+
			    "\"service_name\" : \"YARN\""+
			  "},"+
			  "\"metrics\" : {"+
			    "\"yarn\" : {"+
			      "\"Queue\" : {"+
			        "\"root\" : {"+
			          "\"AMResourceLimitMB\" : 0,"+
			          "\"AMResourceLimitVCores\" : 0,"+
			          "\"ActiveApplications\" : 0,"+
			          "\"ActiveUsers\" : 0,"+
			          "\"AggregateContainersAllocated\" : 0,"+
			          "\"AggregateContainersReleased\" : 0,"+
			          "\"AllocatedContainers\" : 0,"+
			          "\"AllocatedMB\" : 0,"+
			          "\"AllocatedVCores\" : 0,"+
			          "\"AppAttemptFirstContainerAllocationDelayAvgTime\" : 0.0,"+
			          "\"AppAttemptFirstContainerAllocationDelayNumOps\" : 0,"+
			          "\"AppsCompleted\" : 0,"+
			          "\"AppsFailed\" : 0,"+
			          "\"AppsKilled\" : 0,"+
			          "\"AppsPending\" : 0,"+
			          "\"AppsRunning\" : 0,"+
			          "\"AppsSubmitted\" : 0,"+
			          "\"AvailableMB\" : 40960,"+
			          "\"AvailableVCores\" : 12,"+
			          "\"PendingContainers\" : 0,"+
			          "\"PendingMB\" : 0,"+
			          "\"PendingVCores\" : 0,"+
			          "\"ReservedContainers\" : 0,"+
			          "\"ReservedMB\" : 0,"+
			          "\"ReservedVCores\" : 0,"+
			          "\"UsedAMResourceMB\" : 0,"+
			          "\"UsedAMResourceVCores\" : 0,"+
			          "\"running_0\" : 0,"+
			          "\"running_1440\" : 0,"+
			          "\"running_300\" : 0,"+
			          "\"running_60\" : 0,"+
			          "\"default\" : {"+
			            "\"AMResourceLimitMB\" : 0,"+
			            "\"AMResourceLimitVCores\" : 0,"+
			            "\"ActiveApplications\" : 0,"+
			            "\"ActiveUsers\" : 0,"+
			            "\"AggregateContainersAllocated\" : 0,"+
			            "\"AggregateContainersReleased\" : 0,"+
			            "\"AllocatedContainers\" : 0,"+
			            "\"AllocatedMB\" : 0,"+
			            "\"AllocatedVCores\" : 0,"+
			            "\"AppAttemptFirstContainerAllocationDelayAvgTime\" : 0.0,"+
			            "\"AppAttemptFirstContainerAllocationDelayNumOps\" : 0,"+
			            "\"AppsCompleted\" : 0,"+
			            "\"AppsFailed\" : 0,"+
			            "\"AppsKilled\" : 0,"+
			            "\"AppsPending\" : 0,"+
			            "\"AppsRunning\" : 0,"+
			            "\"AppsSubmitted\" : 0,"+
			            "\"AvailableMB\" : 18431,"+
			            "\"AvailableVCores\" : 5,"+
			            "\"PendingContainers\" : 0,"+
			            "\"PendingMB\" : 0,"+
			            "\"PendingVCores\" : 0,"+
			            "\"ReservedContainers\" : 0,"+
			            "\"ReservedMB\" : 0,"+
			            "\"ReservedVCores\" : 0,"+
			            "\"UsedAMResourceMB\" : 0,"+
			            "\"UsedAMResourceVCores\" : 0,"+
			            "\"running_0\" : 0,"+
			            "\"running_1440\" : 0,"+
			            "\"running_300\" : 0,"+
			            "\"running_60\" : 0"+
			          "},"+
			          "\"demo1\" : {"+
			            "\"AMResourceLimitMB\" : 1024,"+
			            "\"AMResourceLimitVCores\" : 1,"+
			            "\"ActiveApplications\" : 0,"+
			            "\"ActiveUsers\" : 0,"+
			            "\"AggregateContainersAllocated\" : 0,"+
			            "\"AggregateContainersReleased\" : 0,"+
			            "\"AllocatedContainers\" : 0,"+
			            "\"AllocatedMB\" : 0,"+
			            "\"AllocatedVCores\" : 0,"+
			            "\"AppAttemptFirstContainerAllocationDelayAvgTime\" : 0.0,"+
			            "\"AppAttemptFirstContainerAllocationDelayNumOps\" : 0,"+
			            "\"AppsCompleted\" : 0,"+
			            "\"AppsFailed\" : 0,"+
			            "\"AppsKilled\" : 0,"+
			            "\"AppsPending\" : 0,"+
			            "\"AppsRunning\" : 0,"+
			            "\"AppsSubmitted\" : 0,"+
			            "\"AvailableMB\" : 1024,"+
			            "\"AvailableVCores\" : 0,"+
			            "\"PendingContainers\" : 0,"+
			            "\"PendingMB\" : 0,"+
			            "\"PendingVCores\" : 0,"+
			            "\"ReservedContainers\" : 0,"+
			            "\"ReservedMB\" : 0,"+
			            "\"ReservedVCores\" : 0,"+
			            "\"UsedAMResourceMB\" : 0,"+
			            "\"UsedAMResourceVCores\" : 0,"+
			            "\"running_0\" : 0,"+
			            "\"running_1440\" : 0,"+
			            "\"running_300\" : 0,"+
			            "\"running_60\" : 0"+
			          "},"+
			          "\"demo2\" : {"+
			            "\"AMResourceLimitMB\" : 1024,"+
			            "\"AMResourceLimitVCores\" : 1,"+
			            "\"ActiveApplications\" : 0,"+
			            "\"ActiveUsers\" : 0,"+
			            "\"AggregateContainersAllocated\" : 0,"+
			            "\"AggregateContainersReleased\" : 0,"+
			            "\"AllocatedContainers\" : 0,"+
			            "\"AllocatedMB\" : 0,"+
			            "\"AllocatedVCores\" : 0,"+
			            "\"AppAttemptFirstContainerAllocationDelayAvgTime\" : 0.0,"+
			            "\"AppAttemptFirstContainerAllocationDelayNumOps\" : 0,"+
			            "\"AppsCompleted\" : 0,"+
			            "\"AppsFailed\" : 0,"+
			            "\"AppsKilled\" : 0,"+
			            "\"AppsPending\" : 0,"+
			            "\"AppsRunning\" : 0,"+
			            "\"AppsSubmitted\" : 0,"+
			            "\"AvailableMB\" : 1024,"+
			            "\"AvailableVCores\" : 0,"+
			            "\"PendingContainers\" : 0,"+
			            "\"PendingMB\" : 0,"+
			            "\"PendingVCores\" : 0,"+
			            "\"ReservedContainers\" : 0,"+
			            "\"ReservedMB\" : 0,"+
			            "\"ReservedVCores\" : 0,"+
			            "\"UsedAMResourceMB\" : 0,"+
			            "\"UsedAMResourceVCores\" : 0,"+
			            "\"running_0\" : 0,"+
			            "\"running_1440\" : 0,"+
			            "\"running_300\" : 0,"+
			            "\"running_60\" : 0"+
			          "}"+
			        "}"+
			      "}"+
			    "}"+
			  "}"+
			"}").build();
	}
	
}
