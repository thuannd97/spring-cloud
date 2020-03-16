package com.thuannd.oauth2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

    private static final String RESOURCE_ID = "oauth2-resource";
    private static final String CLIENT_ID = "clent-id";
    private static final String CLIENT_SECRET = "clent-secret";
    private static final String AUTHORIZATION_CODE = "authorization-code";
    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String SCOPE = "user_infor";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    // immemory or JDBC to implement ClientDetailService
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
        .withClient(CLIENT_ID)
        .secret(CLIENT_SECRET)
        .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
        .authorizedGrantTypes(CLIENT_CREDENTIALS, "password")
        .resourceIds(RESOURCE_ID)
        .scopes("read", "write", "trust")
        .accessTokenValiditySeconds(5000);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()"); // isAuthenticated() return true if user is not anonymous
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

}