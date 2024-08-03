package com.gokapture.taskapp;

import com.gokapture.taskapp.security.repositories.JpaRegisteredClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import java.util.UUID;

@SpringBootTest
class TaskAppApplicationTests {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private JpaRegisteredClientRepository jpaRegisteredClientRepository;

    @Autowired
    public void setBCryptPasswordEncoder(
            BCryptPasswordEncoder bCryptPasswordEncoder,
            JpaRegisteredClientRepository jpaRegisteredClientRepository
    ) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jpaRegisteredClientRepository = jpaRegisteredClientRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void storeRegisteredClientIntoDB() {
//        RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("oidc-client")
//				.clientSecret(bCryptPasswordEncoder.encode("secret"))
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                .redirectUri("https://oauth.pstmn.io/v1/callback")
//                .postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback")
//                .redirectUri("https://oauth.pstmn.io/v1/browser-callback")
//                .postLogoutRedirectUri("https://oauth.pstmn.io/v1/browser-callback")
//                .redirectUri("https://oauthdebugger.com/debug")
//                .scope(OidcScopes.OPENID)
//                .scope(OidcScopes.PROFILE)
//                .scope("ADMIN")
//                .scope("USER")
//                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//                .build();
//
//		jpaRegisteredClientRepository.save(oidcClient);
    }


}
