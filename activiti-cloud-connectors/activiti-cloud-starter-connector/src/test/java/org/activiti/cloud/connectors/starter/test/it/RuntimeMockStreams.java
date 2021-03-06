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
package org.activiti.cloud.connectors.starter.test.it;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface RuntimeMockStreams {

    String INTEGRATION_RESULT_CONSUMER = "integrationResultsConsumer";
    String INTEGRATION_EVENT_PRODUCER = "integrationEventsProducer";
    String INTEGRATION_ERROR_CONSUMER = "integrationErrorConsumer";

    @Input(INTEGRATION_RESULT_CONSUMER)
    SubscribableChannel integrationResultsConsumer();

    @Output(INTEGRATION_EVENT_PRODUCER)
    MessageChannel integrationEventsProducer();

    @Input(INTEGRATION_ERROR_CONSUMER)
    SubscribableChannel integrationErrorConsumer();

}
