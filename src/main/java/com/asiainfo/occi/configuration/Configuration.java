package com.asiainfo.occi.configuration;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Singleton;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  @SuppressWarnings("unchecked")
  public Map<String, String> ambariRestServer(){
    if(null != document){
      List<Element> elements = (List<Element>)rootElement.elements("ambari-rest");
      assert elements.size() == 1;
      Element e = elements.get(0);
      Map<String, String> map = new HashMap<>();
      map.put("username", e.elementText("username"));
      map.put("password", e.elementText("password"));
      map.put("url", e.elementText("url"));
      logger.info(map.toString());
      return map;
    }
    return null;
  }
  
  @SuppressWarnings("unchecked")
  public Properties hdfs(){
    if(null != document){
      List<Element> elements = (List<Element>)rootElement.elements("hdfs");
      assert elements.size() == 1;
      Element e = elements.get(0);
      List<Element> paras = e.elements();
      Properties prop = new Properties();
      paras.forEach(p -> {
    	  prop.setProperty(p.getName(), p.getStringValue());
      });
      return prop;
    }
    return null;
  }
  
  public static void main(String[] args) {
	Configuration.getInstance().hdfs();
}
}
