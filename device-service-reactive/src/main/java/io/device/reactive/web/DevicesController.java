package io.device.reactive.web;

import io.device.reactive.model.DeviceModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class DevicesController {

    
    @SendTo("/topic/devices")
    public DeviceModel send(DeviceModel deviceModel)  {
        log.debug("################");
        return  deviceModel;
    }
}
