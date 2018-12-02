package io.device.reactive.services;

import java.time.Duration;
import java.util.Random;

import com.googlecode.jmapper.JMapper;

import io.device.reactive.domain.Device;
import io.device.reactive.model.DeviceModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DeviceRetrieveReactiveServiceImpl implements DeviceRetrieveReactiveService {

    JMapper<DeviceModel, Device> deviceModelDeviceJMapper;

    public DeviceRetrieveReactiveServiceImpl(
        JMapper<DeviceModel, Device> deviceModelDeviceJMapper) {
        this.deviceModelDeviceJMapper = deviceModelDeviceJMapper;
    }

    // @Override
    // public Flux<DeviceModel> findAll() {
    //     return deviceReactiveRepository
    //             .findAll()
    //             .map(   deviceModelDeviceJMapper::getDestination)
    //             ;
    // }


    /**
     * Generates a stream of <code>Long</code> numbers
     */
    @Override
    public Flux<Long> fetchLongStream(Duration period) {

        return 
         Flux.generate(
            () -> 50, 
            (state, sink) -> {
              sink.next(Long.valueOf(state)); 
              if (state == 200) sink.complete(); 
              return state + 1; 
            })
            .zipWith(Flux.interval(period))
            .map( t->(Long)t.getT1())
            .log(">> "+ this.getClass().getName())
            ;

        }
}
