package com.franca.hroauth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Validated
@ConfigurationProperties(value = "oauth.service-registry")
public class AuthProperties {


    private String providerUri;

    private JksProperties jks;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
   public static class JksProperties {
        private String keypass;
        private String storepass;

        private String alias;
        private String path;
    }
}

