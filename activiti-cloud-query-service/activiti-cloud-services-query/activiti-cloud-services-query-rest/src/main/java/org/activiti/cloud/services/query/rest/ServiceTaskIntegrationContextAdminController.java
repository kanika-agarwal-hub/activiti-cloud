/*
 * Copyright 2017-2020 Alfresco Software, Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.cloud.services.query.rest;

import org.activiti.cloud.api.process.model.CloudIntegrationContext;
import org.activiti.cloud.services.query.app.repository.EntityFinder;
import org.activiti.cloud.services.query.app.repository.IntegrationContextRepository;
import org.activiti.cloud.services.query.model.IntegrationContextEntity;
import org.activiti.cloud.services.query.rest.assembler.IntegrationContextRepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/admin/v1/service-tasks",
        produces = {
                MediaTypes.HAL_JSON_VALUE,
                MediaType.APPLICATION_JSON_VALUE
        })
public class ServiceTaskIntegrationContextAdminController {

    private final IntegrationContextRepository repository;

    private final IntegrationContextRepresentationModelAssembler representationModelAssembler;

    private final EntityFinder entityFinder;


    public ServiceTaskIntegrationContextAdminController(IntegrationContextRepository repository,
                                             IntegrationContextRepresentationModelAssembler representationModelAssembler,
                                             EntityFinder entityFinder) {
        this.repository = repository;
        this.representationModelAssembler = representationModelAssembler;
        this.entityFinder = entityFinder;
    }

    @RequestMapping(value = "/{serviceTaskId}/integration-context", method = RequestMethod.GET)
    public EntityModel<CloudIntegrationContext> findById(@PathVariable String serviceTaskId) {

        IntegrationContextEntity entity = entityFinder.findById(repository,
                                                                serviceTaskId,
                                                                "Unable to find integration context entity for the given id:'" + serviceTaskId + "'");

        return representationModelAssembler.toModel(entity);
    }
}