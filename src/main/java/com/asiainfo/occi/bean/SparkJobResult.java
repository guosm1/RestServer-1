package com.asiainfo.occi.bean;

/**
 * Created by xiaoman on 2018/4/18.
 */
public class SparkJobResult {
  private Double count;

  public SparkJobResult(Double count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "SparkJobResult{" +
      "count=" + count +
      '}';
  }

  public Double getCount() {
    return count;
  }

  public void setCount(Double count) {
    this.count = count;
  }
}
