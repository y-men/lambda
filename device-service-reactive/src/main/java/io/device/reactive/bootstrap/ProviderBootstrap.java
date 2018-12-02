package io.device.reactive.bootstrap;

import io.device.reactive.services.DeviceRetrieveReactiveService;
import io.device.reactive.web.DevicesController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProviderBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    DeviceRetrieveReactiveService service;
    DevicesController devicesController;


    public ProviderBootstrap(DeviceRetrieveReactiveService service, DevicesController devicesController) {
        this.service = service;
        this.devicesController = devicesController;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        service.findAll().subscribe( deviceModel -> {
            log.debug(">> subscribe()");
            devicesController.send( deviceModel);
        });
    }
}
