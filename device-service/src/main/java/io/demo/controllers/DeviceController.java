package io.demo.controllers;


import io.demo.domain.Device;
import io.demo.model.DeviceModel;
import io.demo.services.DeviceRetrieveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api( description = "Add, Remove and Configure operations the mobile devices")
@RestController
@Slf4j
public class DeviceController {

    @Autowired
    DeviceRetrieveService deviceRetrieveService;

    @CrossOrigin
    @ApiOperation( value = "Get a list of available devices")
    @RequestMapping( value = "/list" ,method = RequestMethod.GET)
    public List<DeviceModel> findAll(){

        return deviceRetrieveService.findAll();
    }

    @CrossOrigin
    @ApiOperation( value = "Add a new device or update existing")
    @RequestMapping( value = "/update" ,method = RequestMethod.POST)
    public DeviceModel update( @RequestBody DeviceModel model){
        return deviceRetrieveService.update( model );
    }
}
