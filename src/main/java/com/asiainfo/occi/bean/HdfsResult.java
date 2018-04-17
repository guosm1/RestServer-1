package com.asiainfo.occi.bean;

public class HdfsResult {
  private Double total;
  private Double used;

  public HdfsResult(Double total, Double used) {
    this.total = total;
    this.used = used;
  }

  @Override
  public String toString() {
    return "HdfsResult{" +
      "total=" + total +
      ", used=" + used +
      '}';
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public Double getUsed() {
    return used;
  }

  public void setUsed(Double used) {
    this.used = used;
  }
}
