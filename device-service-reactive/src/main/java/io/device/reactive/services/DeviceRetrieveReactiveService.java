package io.device.reactive.services;

import java.time.Duration;

import io.device.reactive.model.DeviceModel;
import reactor.core.publisher.Flux;

public interface DeviceRetrieveReactiveService {
    Flux<DeviceModel> findAll();
    public Flux<Long> fetchLongStream(Duration period) ;

}
