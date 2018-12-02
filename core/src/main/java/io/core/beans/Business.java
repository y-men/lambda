package io.core.beans;

import io.core.annotations.TraceExecutionTime;
import io.core.annotations.TraceMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Business {

    String name = "Name1";
    String description = "Description 1";
    @TraceMethod
    public String retrieveCustomData( String a, int z, boolean b){
        return "OK";
    }

    @TraceExecutionTime
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
