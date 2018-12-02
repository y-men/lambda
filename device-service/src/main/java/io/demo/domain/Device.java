package io.demo.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.googlecode.jmapper.annotations.JGlobalMap;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@JGlobalMap
public class Device {

    @Id
    private ObjectId _id;
    private String name;
    private String desc;
    private boolean toggle;
    private Double receptionLevel;
    private Double hardwareVersion;
    private Double softwareVersion;


}
