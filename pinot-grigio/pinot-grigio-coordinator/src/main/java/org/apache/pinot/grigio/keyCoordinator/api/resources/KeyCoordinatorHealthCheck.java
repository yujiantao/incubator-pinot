/**
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
package org.apache.pinot.grigio.keyCoordinator.api.resources;

import org.apache.pinot.grigio.keyCoordinator.starter.KeyCoordinatorStarter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(tags = "Health")
@Path("/")
public class KeyCoordinatorHealthCheck {

  @Inject
  private KeyCoordinatorStarter keyCoordinatorStarter;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("health")
  @ApiOperation(value = "Checking key coordinator health")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "KC is healthy"),
      @ApiResponse(code = 503, message = "KC is disabled")
  })
  public String getKCHealth() {

    if (keyCoordinatorStarter != null && keyCoordinatorStarter.isRunning()) {
      return "OK";
    } else {
      throw new WebApplicationException("Pinot key coordinator is disabled", Response.Status.SERVICE_UNAVAILABLE);
    }
  }

}