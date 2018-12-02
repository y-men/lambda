package io.porte;

import io.porte.filters.KafkaProducerFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class Porte {

    public static void main(String[] args) {
        SpringApplication.run(Porte.class, args);
    }

    @Bean
    public KafkaProducerFilter kafkaProducerFilter(){
        return new KafkaProducerFilter();
    }
}
