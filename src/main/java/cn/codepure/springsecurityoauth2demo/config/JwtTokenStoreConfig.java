package cn.codepure.springsecurityoauth2demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * JwtToken配置类
 */
@Configuration
public class JwtTokenStoreConfig {

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        // 配置Jwt使用的密钥
        accessTokenConverter.setSigningKey("test_key");
        return accessTokenConverter;
    }

    // 蜜汁bug这个注入说找不到 奇怪 只能用注解注入了
//    @Bean
//    public TokenEnhancer jwtTokenEnhancer() {
//        return new JwtTokenEnhancer();
//    }
}
