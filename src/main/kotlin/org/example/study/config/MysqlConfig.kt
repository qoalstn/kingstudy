package org.example.study.config

import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class MysqlConfig {

    @Value("\${spring.datasource.url}")
    lateinit var dbUrl: String

    @Value("\${spring.datasource.username}")
    lateinit var dbUsername: String

    @Value("\${spring.datasource.password}")
    lateinit var dbPassword: String

    @Value("\${spring.datasource.driver-class-name}")
    lateinit var dbDriver: String

    @Bean
    fun connectDatabase():Database {

        return Database.connect(
            url = dbUrl,
            driver = dbDriver,
            user = dbUsername,
            password =dbPassword
        )
    }
}