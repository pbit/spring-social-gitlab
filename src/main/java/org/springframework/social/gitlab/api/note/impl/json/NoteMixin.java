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
package org.springframework.social.gitlab.api.note.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.springframework.social.gitlab.api.core.impl.json.GitlabObjectMixin;
import org.springframework.social.gitlab.api.note.Note;

/**
 *
 * @author p.hoeffling
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class NoteMixin extends GitlabObjectMixin {
    
    @JsonProperty("id")
    private long id;

    @JsonProperty("body")
    private String body;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("author")
    private Note.Author author;

    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static abstract class AuthorMixin extends GitlabObjectMixin {
        
        @JsonProperty("id")
        private long id;
        
        @JsonProperty("username")
        private String username;
        
        @JsonProperty("email")
        private String email;
        
        @JsonProperty("name")
        private String name;
        
        @JsonProperty("state")
        private String state;
        
        @JsonProperty("created_at")
        private Date createdAt;
        
        
    
    }
}
