/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.pinot.thirdeye.anomaly.classification;

import org.apache.pinot.thirdeye.anomaly.task.TaskInfo;
import org.apache.pinot.thirdeye.datalayer.dto.ClassificationConfigDTO;

public class ClassificationTaskInfo implements TaskInfo {
  private long jobexecutionId;
  private long windowStartTime;
  private long windowEndTime;
  private ClassificationConfigDTO classificationConfigDTO;

  public ClassificationTaskInfo() {
  }

  public ClassificationTaskInfo(long jobexecutionId, long windowStartTime, long windowEndTime,
      ClassificationConfigDTO classificationConfigDTO) {
    this.jobexecutionId = jobexecutionId;
    this.windowStartTime = windowStartTime;
    this.windowEndTime = windowEndTime;
    this.classificationConfigDTO = classificationConfigDTO;
  }

  public long getJobexecutionId() {
    return jobexecutionId;
  }

  public void setJobexecutionId(long jobexecutionId) {
    this.jobexecutionId = jobexecutionId;
  }

  public long getWindowStartTime() {
    return windowStartTime;
  }

  public void setWindowStartTime(long windowStartTime) {
    this.windowStartTime = windowStartTime;
  }

  public long getWindowEndTime() {
    return windowEndTime;
  }

  public void setWindowEndTime(long windowEndTime) {
    this.windowEndTime = windowEndTime;
  }

  public ClassificationConfigDTO getClassificationConfigDTO() {
    return classificationConfigDTO;
  }

  public void setClassificationConfigDTO(ClassificationConfigDTO classificationConfigDTO) {
    this.classificationConfigDTO = classificationConfigDTO;
  }
}
