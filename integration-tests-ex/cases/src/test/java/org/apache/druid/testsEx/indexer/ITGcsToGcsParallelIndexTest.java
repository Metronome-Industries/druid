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

package org.apache.druid.testsEx.indexer;

import junitparams.Parameters;
import org.apache.druid.java.util.common.Pair;
import org.apache.druid.testsEx.categories.GcsDeepStorage;
import org.apache.druid.testsEx.config.DruidTestRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * IMPORTANT:
 * To run this test, you must:
 * 1) Set the bucket and path for your data. This can be done by setting -Ddruid.test.config.cloudBucket and
 *    -Ddruid.test.config.cloudPath or setting "cloud_bucket" and "cloud_path" in the config file.
 * 2) Copy wikipedia_index_data1.json, wikipedia_index_data2.json, and wikipedia_index_data3.json
 *    located in integration-tests/src/test/resources/data/batch_index/json to your GCS at the location set in step 1.
 * 3) Provide -Doverride.config.path=<PATH_TO_FILE> with gcs configs set. See
 *    integration-tests/docker/environment-configs/override-examples/gcs for env vars to provide.
 * 4) Provide -Dresource.file.dir.path=<PATH_TO_FOLDER> with folder that contains GOOGLE_APPLICATION_CREDENTIALS file
 */
@RunWith(DruidTestRunner.class)
@Category(GcsDeepStorage.class)
public class ITGcsToGcsParallelIndexTest extends AbstractGcsInputSourceParallelIndexTest
{
  @Test
  @Parameters(method = "resources")
  public void testGcsIndexData(Pair<String, List<?>> gcsInputSource) throws Exception
  {
    doTest(gcsInputSource, new Pair<>(false, false), "google");
  }
}
