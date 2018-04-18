package com.asiainfo.occi.bean;

public class MapreduceJobResult {
	private Double count;
	
	public MapreduceJobResult(Double count) {
		this.count = count;
	}
	
	@Override
	  public String toString() {
	    return "MapreduceJobResult{" +
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
