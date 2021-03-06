/*
 * Copyright 2015 p.hoeffling.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.gitlab.api.project.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.springframework.social.gitlab.api.core.impl.json.GitlabObjectMixin;

/**
 *
 * @author p.hoeffling
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ProjectHookMixin extends GitlabObjectMixin {

    @JsonProperty("id")
    long id;

    @JsonProperty("url")
    String url;

    @JsonProperty("project_id")
    long projectId;

    @JsonProperty("push_events")
    boolean pushEvents;

    @JsonProperty("issues_events")
    boolean issuesEvents;

    @JsonProperty("merge_requests_events")
    boolean mergeRequestsEvents;

    @JsonProperty("created_at")
    Date createdAt;

}
