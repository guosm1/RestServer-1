package com.asiainfo.occi;

import com.asiainfo.occi.resources.MyResource;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig{
  /**
   * Register JAX-RS application components.
   */
  public Application() {
    register(MyResource.class);
  }
}
