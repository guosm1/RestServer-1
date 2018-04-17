package com.asiainfo.occi.configuration;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;

public class Configuration {
  private static final Logger logger = LoggerFactory.getLogger(Configuration.class);
  private static final String configName = "config.xml";
  private static Document configuration = null;
  private static Element rootElement;
  static{
    try {
      SAXReader reader = new SAXReader();
      URL resource = Configuration.class.getClassLoader().getResource(configName);
      if(resource == null){
        throw new IllegalAccessException("Cannot load config file");
      }
      configuration = reader.read(resource);
      rootElement = configuration.getRootElement();
    }catch (Exception e){
      e.printStackTrace();
      logger.error("Cannot load config file");
    }
  }

  @SuppressWarnings("unchecked")
  public static String esRestServer(){
    if(null != configuration){
      List<Element> elements = (List<Element>)rootElement.elements("es-rest");
      assert elements.size() == 1;
      Element e = elements.get(0);
      logger.info(e.getStringValue().trim());
      return e.getStringValue().trim();
    }
    return null;
  }
}
