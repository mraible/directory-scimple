/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.directory.scim.compliance.tests;

import org.apache.directory.scim.compliance.junit.EmbeddedServerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.emptyString;

@ExtendWith(EmbeddedServerExtension.class)
public class GroupsIT extends ScimpleITSupport {

  @Test
  @DisplayName("Verify Groups endpoint")
  public void groupsEndpoint() {
    get("/Groups")
      .statusCode(200)
      .body(
        "Resources", not(empty()),
        "schemas", hasItem(SCHEMA_LIST_RESPONSE),
        "itemsPerPage", isNumber(),
        "startIndex", isNumber(),
        "totalResults", isNumber(),
        "Resources[0].id", not(emptyString())
      );
  }
}
