package org.example.elastictest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "org.example.elastictest.document.repository")
public class ElasticTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticTestApplication.class, args);
    }

}
