package com.cristi.web.mentool.infra.persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.cristi.web.mentool")
public class PersistenceConfig {

    private final MongoTemplate mongoTemplate;

    public PersistenceConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Value("${spring.data.mongodb.uri}")
    private String mongoURI;
    @Value("${spring.data.mongodb.database}")
    private String mongoDbName;

    private final String MIGRATION_PACKAGE = "com.cristi.web.incognito.infra.persistence.changelogs";


}
