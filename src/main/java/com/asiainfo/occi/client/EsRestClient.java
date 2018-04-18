package com.asiainfo.occi.client;

import com.asiainfo.occi.bean.generated.Hdfs;
import com.asiainfo.occi.bean.generated.Jobs;

public interface EsRestClient {
  Hdfs hdfsStorage();
  Jobs mapreducejobsStatistics();
}
