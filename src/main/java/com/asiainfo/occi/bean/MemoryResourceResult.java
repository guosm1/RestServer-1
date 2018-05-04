package com.asiainfo.occi.bean;

import java.util.ArrayList;
import java.util.List;

public class MemoryResourceResult {
private List<Pod> pods = new ArrayList<>();
	
	public MemoryResourceResult(List<Pod> pods) {
		this.pods = pods;
	}
	
	public List<Pod> getPods() {
		return pods;
	}

	public void setPods(List<Pod> pods) {
		this.pods = pods;
	}

	public static class Pod {
		private Double memory;
		private Double key;
		public Pod(Double memory, Double key) {
			this.memory = memory;
			this.key = key;
		}
		@Override
		public String toString() {
			return "ResourceResult" +
		      "memory=" + memory +
		      ", key=" + key +
		      '}';
		}
		
		public Double getmemory() {
			return memory;
		}
		public void setmemory(Double memory) {
			this.memory = memory;
		}
		public Double getKey() {
			return key;
		}
		public void setKey(Double key) {
			this.key = key;
		}
	}

}
