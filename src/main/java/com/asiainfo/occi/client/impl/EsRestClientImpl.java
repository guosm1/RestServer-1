package com.asiainfo.occi.client.impl;

import com.asiainfo.occi.client.EsRestClient;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class EsRestClientImpl implements EsRestClient{
  private final static Logger logger = LoggerFactory.getLogger(EsRestClientImpl.class);
  private final static WebTarget webTarget;
  static{
    Client client = ClientBuilder.newClient(new ClientConfig());
    webTarget = client.target("http://localhost:8080/api/v1");
  }

  public String getData(){
    WebTarget resourceWebTarget = webTarget.path("resource");
    Invocation.Builder request = resourceWebTarget.request();
    Response response = request.get();
    logger.info(response.readEntity(String.class));
    return null;
  }
}
