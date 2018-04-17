package com.asiainfo.occi;

import com.asiainfo.occi.resources.DashboardChartsResource;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig{
  /**
   * Register JAX-RS application components.
   */
  public Application() {
    register(DashboardChartsResource.class);
  }
}
