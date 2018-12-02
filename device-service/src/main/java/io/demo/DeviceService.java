package io.demo;

import io.demo.bootstrap.BootstrapDevices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
@ConfigurationProperties(prefix = "application")
@EnableDiscoveryClient
@EnableAspectJAutoProxy
@EnableSwagger2
public class DeviceService {
    public static void main(String[] args) {
        SpringApplication.run(DeviceService.class, args);
    }

    @Autowired
    BootstrapDevices bootstrapDevices;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("Service: " + greeting + " is up.");
    }



// ~~~~~~~~~~~ Configuration Properties

    private String greeting;

   // @Value("${lucky.word}")
    private String luckyword;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getLuckyword() {
        return luckyword;
    }

    public void setLuckyword(String luckyword) {
        this.luckyword = luckyword;
    }
}
