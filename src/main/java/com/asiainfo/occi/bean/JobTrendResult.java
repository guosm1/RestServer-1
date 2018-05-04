package com.asiainfo.occi.bean;

import java.util.ArrayList;
import java.util.List;

public class JobTrendResult {
	private List<Pod> pods = new ArrayList<>();
	
	
	public JobTrendResult(List<Pod> pods) {
		this.pods = pods;
	}

	public List<Pod> getPods() {
		return pods;
	}
	
	public void setPods(List<Pod> pods) {
		this.pods = pods;
	}
	
	@Override
	public String toString() {
		return "JobTrendResult [pods=" + pods + "]";
	}
	
	public static class Pod{
		private Double docCount;
		private Double key;
		
		public Pod(Double docCount, Double key) {
			this.docCount = docCount;
			this.key = key;
		}

		public Double getDocCount() {
			return docCount;
		}
		
		public void setDocCount(Double docCount) {
			this.docCount = docCount;
		}
		
		public Double getKey() {
			return key;
		}
		
		public void setKey(Double key) {
			this.key = key;
		}
		
		@Override
		public String toString() {
			return "Pod [docCount=" + docCount + ", key=" + key + "]";
		}
	}

}
