package com.app.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("config-server-mongo")
public class ServerConfig {

    @Value("${mongoUri}")
    private  String mongoUri;

    @Value("${mongoDbName}")
    private  String mongoDbName;

    public  String getMongoUri() {
        return mongoUri;
    }

    public String getMongoDbName() {
        return mongoDbName;
    }
}
