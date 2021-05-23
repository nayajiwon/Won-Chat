package com.jw.demo.Properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="spring.security.oauth2.client.registration.naver")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OauthProperties {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String authorizationGrantType;
    private String scope;
    private String clientName;

}
