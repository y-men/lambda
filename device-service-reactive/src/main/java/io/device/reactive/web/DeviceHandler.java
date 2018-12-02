package io.device.reactive.web;

import com.googlecode.jmapper.JMapper;
import io.device.reactive.domain.Device;
import io.device.reactive.model.DeviceModel;
import io.device.reactive.services.DeviceRetrieveReactiveService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
public class DeviceHandler {
    JMapper<DeviceModel, Device> deviceModelDeviceJMapper;
    DeviceRetrieveReactiveService deviceRetrieveReactiveService;

    public DeviceHandler(JMapper<DeviceModel, Device> deviceModelDeviceJMapper, DeviceRetrieveReactiveService deviceRetrieveReactiveService) {
        this.deviceModelDeviceJMapper = deviceModelDeviceJMapper;
        this.deviceRetrieveReactiveService = deviceRetrieveReactiveService;
    }

    public Mono<ServerResponse> listDevices(ServerRequest request) {
        int size = Integer.parseInt(request.queryParam("size").orElse("10"));
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deviceRetrieveReactiveService.findAll().take(size),
                        DeviceModel.class);
    }

    public Mono<ServerResponse> streamDevices(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(deviceRetrieveReactiveService.findAll(),
                        DeviceModel.class);

    }
}
