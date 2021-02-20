package com.es.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport;
import org.springframework.data.elasticsearch.core.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class TransportClientConfig extends ElasticsearchConfigurationSupport {

  @Bean
  public Client elasticsearchClient() throws UnknownHostException {
    Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
    TransportClient client = new PreBuiltTransportClient(settings);
    client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    return client;
  }

  @Bean(name = {"elasticsearchOperations", "elasticsearchTemplate"})
  public ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException {
  	return new ElasticsearchTemplate(elasticsearchClient(), entityMapper());
  }

  // use the ElasticsearchEntityMapper
  @Bean
  @Override
  public EntityMapper entityMapper() {
    ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper(elasticsearchMappingContext(),
  	  new DefaultConversionService());
    entityMapper.setConversions(elasticsearchCustomConversions());
    return entityMapper;
  }

//  @Bean
//  public ReactiveElasticsearchClient reactiveElasticsearchClient() {
//    return ReactiveRestClients.create(ClientConfiguration.localhost());
//  }
//  @Bean
//  public ElasticsearchConverter elasticsearchConverter() {
//    return new MappingElasticsearchConverter(elasticsearchMappingContext());
//  }
//  @Bean
//  public SimpleElasticsearchMappingContext elasticsearchMappingContext() {
//    return new SimpleElasticsearchMappingContext();
//  }
//  @Bean
//  public ReactiveElasticsearchOperations reactiveElasticsearchOperations() {
//    return new ReactiveElasticsearchTemplate(reactiveElasticsearchClient(), elasticsearchConverter());
//  }
}