package com.asiainfo.occi.client;

import javax.ws.rs.core.Response;

public interface AmbariRestClient {
  Response dataNodeInfo(String clusterName);
  Response nameNodeInfo(String clusterName);
  Response hostInfo(String clusterName);
  Response yarnQueue(String clusterName);
}
