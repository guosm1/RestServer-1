package com.asiainfo.occi.configuration;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.net.URL;
import java.util.List;

@Singleton
public class Configuration {
  private static final Logger logger = LoggerFactory.getLogger(Configuration.class);
  private static final String configName = "config.xml";
  private static Document document = null;
  private static Element rootElement;
  private static final Configuration configuration = new Configuration();

  private Configuration(){
    try {
      SAXReader reader = new SAXReader();
      URL resource = Configuration.class.getClassLoader().getResource(configName);
      if(resource == null){
        throw new IllegalAccessException("Cannot load config file");
      }
      document = reader.read(resource);
      rootElement = document.getRootElement();
    }catch (Exception e){
      e.printStackTrace();
      logger.error("Cannot load config file");
    }
  }

  public static Configuration getInstance(){
    return configuration;
  }

  @SuppressWarnings("unchecked")
  public String esRestServer(){
    if(null != document){
      List<Element> elements = (List<Element>)rootElement.elements("es-rest");
      assert elements.size() == 1;
      Element e = elements.get(0);
      logger.info(e.getStringValue().trim());
      return e.getStringValue().trim();
    }
    return null;
  }
}
