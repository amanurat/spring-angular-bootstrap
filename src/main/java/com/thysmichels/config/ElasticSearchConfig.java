package com.thysmichels.config;

/**
 * Created by tmichels on 8/9/14.
 */

import static org.elasticsearch.node.NodeBuilder.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.thysmichels.repository.elasticsearch")
public class ElasticSearchConfig {

    @Bean
    public ElasticsearchOperations elasticsearchTemplate(){
        return new ElasticsearchTemplate(nodeBuilder().local(true).node().client());
    }
}
