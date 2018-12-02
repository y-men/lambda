package io.voute;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaServer
@Slf4j
public class Voute {
    public static void main(String[] args) {
        SpringApplication.run(Voute.class, args);
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //Porté
        log.debug(" Voûte-  Discovery and config service started.");


    }
}
