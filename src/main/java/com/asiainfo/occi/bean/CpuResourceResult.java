package com.asiainfo.occi.bean;

public class CpuResourceResult {
	private Double vCore;
	private Double key;
	public CpuResourceResult(Double vCore, Double key) {
		// TODO Auto-generated constructor stub
		this.vCore = vCore;
		this.key = key;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ResourceResult" +
	      "vCore=" + vCore +
	      ", key=" + key +
	      '}';
	}
	
	public Double getvCore() {
		return vCore;
	}
	public void setvCore(Double vCore) {
		this.vCore = vCore;
	}
	public Double getKey() {
		return key;
	}
	public void setKey(Double key) {
		this.key = key;
	}
}
