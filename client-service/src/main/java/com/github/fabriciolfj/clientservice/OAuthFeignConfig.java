package com.github.fabriciolfj.clientservice;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Slf4j
@Configuration
public class OAuthFeignConfig {

    private final OAuth2AuthorizedClientService auth2AuthorizedClientService;
    private final ClientRegistrationRepository clientRegistrationRepository;

    public OAuthFeignConfig(final OAuth2AuthorizedClientService auth2AuthorizedClientService, final ClientRegistrationRepository clientRegistrationRepository) {
        this.auth2AuthorizedClientService = auth2AuthorizedClientService;
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        final ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId("keycloak");
        final OAuthClientCredentialsFeignManager OAuthClientCredentialsFeignManager = new OAuthClientCredentialsFeignManager(authorizedClientManager(), clientRegistration);
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + OAuthClientCredentialsFeignManager.getAccessToken(clientRegistration));
        };
    }

    @Bean
    OAuth2AuthorizedClientManager authorizedClientManager() {
        OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
                .clientCredentials()
                .build();

        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, auth2AuthorizedClientService);
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
        return authorizedClientManager;
    }
}
