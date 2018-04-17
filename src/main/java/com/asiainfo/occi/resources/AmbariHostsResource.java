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

@Path("ambari/host")
@Api(value = "/ambari/host", description = "Ambari host rest")
public class AmbariHostsResource {

	@GET
	@Path("/cluster/{clusterName}/hosts/info")
	@ApiOperation(value = "Get all hosts info")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad request", responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = Boolean.class)),
			@ApiResponse(code = 404, message = "Page not found") })
	@Produces((MediaType.APPLICATION_JSON + ";charset=utf-8"))
	public Response getHostsInfo(@PathParam("clusterName") String clusterName) {
		//http://10.1.236.61:8080/api/v1/clusters/testcluster/services/HDFS/components/NAMENODE?fields=ServiceComponentInfo
		return Response.ok().entity("{"+
  "\"href\" : \"http://10.1.233.161:8080/api/v1/clusters/testcluster/hosts?fields=metrics/disk/disk_free,metrics/disk/disk_total,metrics/load/load_one,Hosts/cpu_count,Hosts/total_mem\","+
  "\"items\" : ["+
    "{"+
      "\"href\" : \"http://10.1.233.161:8080/api/v1/clusters/testcluster/hosts/ochadoop111.jcloud.local\","+
      "\"Hosts\" : {"+
        "\"cluster_name\" : \"testcluster\","+
        "\"cpu_count\" : 8,"+
        "\"host_name\" : \"ochadoop111.jcloud.local\","+
        "\"total_mem\" : 32947928"+
      "},"+
      "\"metrics\" : {"+
        "\"disk\" : {"+
          "\"disk_free\" : 436.95,"+
          "\"disk_total\" : 527.94"+
        "},"+
        "\"load\" : {"+
          "\"load_one\" : 0.43"+
        "}"+
      "}"+
    "},"+
    "{"+
      "\"href\" : \"http://10.1.233.161:8080/api/v1/clusters/testcluster/hosts/ochadoop112.jcloud.local\","+
      "\"Hosts\" : {"+
        "\"cluster_name\" : \"testcluster\","+
        "\"cpu_count\" : 8,"+
        "\"host_name\" : \"ochadoop112.jcloud.local\","+
        "\"total_mem\" : 32947928"+
      "},"+
      "\"metrics\" : {"+
        "\"disk\" : {"+
          "\"disk_free\" : 446.15,"+
          "\"disk_total\" : 527.94"+
        "},"+
        "\"load\" : {"+
          "\"load_one\" : 0.62"+
        "}"+
      "}"+
    "},"+
    "{"+
      "\"href\" : \"http://10.1.233.161:8080/api/v1/clusters/testcluster/hosts/xiaomm.jcloud.local\","+
      "\"Hosts\" : {"+
        "\"cluster_name\" : \"testcluster\","+
        "\"cpu_count\" : 8,"+
        "\"host_name\" : \"xiaomm.jcloud.local\","+
        "\"total_mem\" : 32947928"+
      "},"+
      "\"metrics\" : {"+
        "\"disk\" : {"+
          "\"disk_free\" : 447.88,"+
          "\"disk_total\" : 527.94"+
        "},"+
        "\"load\" : {"+
          "\"load_one\" : 0.51"+
        "}"+
      "}"+
   "}"+
  "]"+
"}").build();
	}

}
