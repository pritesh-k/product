package com.app.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for server-related settings, specifically MongoDB configurations.
 */
@Configuration
@ConfigurationProperties("config-server-mongo")
public class ServerConfig {

    // MongoDB URI property
    @Value("${mongoUri}")
    private String mongoUri;

    // MongoDB database name property
    @Value("${mongoDbName}")
    private String mongoDbName;

    /**
     * Get the MongoDB URI.
     *
     * @return The MongoDB URI.
     */
    public String getMongoUri() {
        return mongoUri;
    }

    /**
     * Get the MongoDB database name.
     *
     * @return The MongoDB database name.
     */
    public String getMongoDbName() {
        return mongoDbName;
    }
}
