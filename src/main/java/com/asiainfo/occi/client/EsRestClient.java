package com.asiainfo.occi.client;



import com.asiainfo.occi.bean.generated.Hdfs;
import com.asiainfo.occi.bean.generated.JobTrend;
import com.asiainfo.occi.bean.generated.Jobs;
import com.asiainfo.occi.bean.generated.Resource;

public interface EsRestClient {
  Hdfs hdfsStorage();
  Jobs mapreducejobsStatistics();
  Jobs sparkjobsStatistics();
  Resource cpuResourceTrend(String rangetime, String interval);
  Resource memoryRecourceTrend(String rangetime, String interval);
  JobTrend mapreduceTrend(String rangetime, String interval);
  JobTrend sparkTrend(String rangetime, String interval);
}
