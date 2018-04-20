package com.asiainfo.occi.client;

import com.asiainfo.occi.bean.generated.Hdfs;
import com.asiainfo.occi.bean.generated.Jobs;
import com.asiainfo.occi.bean.generated.Resource;

public interface EsRestClient {
  Hdfs hdfsStorage();
  Jobs mapreducejobsStatistics();
  Jobs sparkjobsStatistics();
  Resource cpuResourceTrend();
}
