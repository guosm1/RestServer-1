package org.asiainfo.ocdp.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyBean {
  private String name;
  private String age;

  public MyBean(String name, String age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }
}
