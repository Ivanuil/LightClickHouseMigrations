package io.github.ivanuil.lightclickhousemigrations;

import com.clickhouse.client.ClickHouseCredentials;
import com.clickhouse.client.ClickHouseNode;
import io.github.ivanuil.lightclickhousemigrations.exception.ClickHouseMigrationsException;
import io.github.ivanuil.lightclickhousemigrations.service.ClickHouseMigrationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.github.ivanuil.lightclickhousemigrations")
public class LightClickHouseMigrationsConfiguration {

    @Bean
    public ClickHouseMigrationService clickHouseMigrationService(
            final ClickHouseNode node, final ClickHouseCredentials credentials,
            @Value("${clickhouse.migrations-folder}") final String folderPath) throws ClickHouseMigrationsException {
        var service = new ClickHouseMigrationService(node, credentials, folderPath);
        service.applyMigrations();
        return service;
    }

}
