package sample.spring.bigben0123;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableJpaRepositories(basePackages = "sample.spring.bigben0123.mysql")
@EnableMongoRepositories(basePackages = "sample.spring.bigben0123.mongo")
public interface Configuration { }