package com.cristi.web.mentool.infra.persistence;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.cristi.web.mentool")
public class PersistenceConfig {
}
