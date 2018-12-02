package io.device.reactive.domain;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
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
