package io.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    /**
     * curl --request GET --url 'http://localhost:8080/demo/'
     * zuul: curl --request GET --url 'http://localhost:8080/device-service/demo/'
     * @return
     */
    @RequestMapping("/demo")
    public String demo(){
        log.debug("In DemoController::demo()");
        return "demo-OK";
    }
}
