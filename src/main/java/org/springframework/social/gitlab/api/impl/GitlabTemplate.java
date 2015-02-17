package org.springframework.social.gitlab.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.gitlab.api.Gitlab;
import org.springframework.social.gitlab.api.GitlabProjectOperations;
import org.springframework.social.gitlab.api.GitlabUriBuilder;
import org.springframework.social.gitlab.api.impl.json.GitlabModule;
import org.springframework.social.gitlab.api.GitlabProfileOperations;
import org.springframework.social.gitlab.api.GitlabUserOperations;
import org.springframework.social.gitlab.api.user.GitlabUserTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.util.Assert;

/**
 *
 * @author p.hoeffling
 */
public class GitlabTemplate extends AbstractOAuth2ApiBinding implements Gitlab {

    private GitlabProfileOperations profileOperations;
 
    private GitlabUserOperations userOperations;
    
    private GitlabProjectOperations projectOperations;
    
    private final GitlabUriBuilder uriBuilder;
    
    public GitlabTemplate(String accessToken, GitlabUriBuilder uriBuilder) {
        super(accessToken);
        Assert.notNull(uriBuilder, "GitlabUriBuilder can not be null.");
        this.uriBuilder = uriBuilder;
        initSubApis();
    }

    @Override
    public GitlabProfileOperations profileOperations() {
        return profileOperations;
    }

    @Override
    public GitlabUserOperations userOperations() {
        return userOperations;
    }

    @Override
    public GitlabProjectOperations projectOperations() {
        return projectOperations;
    }
    
    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        ObjectMapper objectMapper = converter.getObjectMapper();
        objectMapper.registerModule(new GitlabModule());
        
        return converter;
    }

    private void initSubApis() {
        this.profileOperations = new GitlabProfileTemplate(getRestTemplate(), uriBuilder);
        this.userOperations = new GitlabUserTemplate(getRestTemplate(), uriBuilder);
        this.projectOperations = new GitlabProjectTemplate(getRestTemplate(), uriBuilder);
    }
}
