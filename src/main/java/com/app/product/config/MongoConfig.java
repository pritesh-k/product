package com.app.product.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.bson.codecs.UuidCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;

import static org.bson.codecs.configuration.CodecRegistries.fromCodecs;

/**
 * Configuration class for MongoDB settings.
 */
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Autowired
    ServerConfig serverConfig;

    /**
     * Retrieve the database name.
     */
    @Override
    protected String getDatabaseName() {
        return serverConfig.getMongoDbName();
    }

    /**
     * Configure and create the MongoClient.
     */
    @Override
    public MongoClient mongoClient(){
        String uri = serverConfig.getMongoUri();

        // Configure custom codec registry to handle UUID representation
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromCodecs(new UuidCodec(UuidRepresentation.STANDARD)));
        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .codecRegistry(codecRegistry)
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    /**
     * Create the MongoDatabaseFactory.
     */
    @Override
    public MongoDatabaseFactory mongoDbFactory(){
        return new SimpleMongoClientDatabaseFactory(mongoClient(), getDatabaseName());
    }

    /**
     * Create and configure the MongoTemplate.
     */
    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDbFactory(), mongoConverter());
    }

    /**
     * ReadingConverter for converting Date to ZonedDateTime.
     */
    @ReadingConverter
    public static class ZonedDateTimeReadConverter implements Converter<Date, ZonedDateTime>{
        @Override
        public ZonedDateTime convert(Date date) {
            return date.toInstant().atZone(ZoneOffset.UTC);
        }
    }

    /**
     * WritingConverter for converting ZonedDateTime to Date.
     */
    @WritingConverter
    public static class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Date>{
        @Override
        public Date convert(ZonedDateTime zonedDateTime) {
            return Date.from(zonedDateTime.toInstant());
        }
    }

    /**
     * Define custom conversions.
     */
    public MongoCustomConversions customConversions(){
        return new MongoCustomConversions(Arrays.asList(
                new ZonedDateTimeReadConverter(),
                new ZonedDateTimeWriteConverter()));
    }

    /**
     * Create and configure the MongoConverter.
     */
    public MongoConverter mongoConverter(){
        MongoMappingContext mappingContext = new MongoMappingContext();
        DbRefResolver defaultDbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
        MappingMongoConverter mongoConverter = new MappingMongoConverter(defaultDbRefResolver, mappingContext);
        mongoConverter.setCustomConversions(customConversions());
        return mongoConverter;
    }
}