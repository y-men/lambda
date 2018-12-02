package io.demo.model;

import com.googlecode.jmapper.annotations.JGlobalMap;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JGlobalMap
public class DeviceModel {
    private String name;
    private String desc;

    @ApiModelProperty(value = "Indicates whether the device is turned on or off")
    private boolean toggle;
}
