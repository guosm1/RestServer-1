package com.asiainfo.occi.bean;

import java.util.ArrayList;
import java.util.List;

public class CpuResourceResult {
	private List<Pod> pods = new ArrayList<>();
	
	public CpuResourceResult(List<Pod> pods) {
		this.pods = pods;
	}
	
	public List<Pod> getPods() {
		return pods;
	}

	public void setPods(List<Pod> pods) {
		this.pods = pods;
	}

	public static class Pod {
		private Double vCore;
		private Double key;
		public Pod(Double vCore, Double key) {
			this.vCore = vCore;
			this.key = key;
		}
		@Override
		public String toString() {
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
}
