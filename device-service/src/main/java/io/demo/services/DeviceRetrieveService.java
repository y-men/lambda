package io.demo.services;

import io.demo.domain.Device;
import io.demo.model.DeviceModel;

import java.util.List;

public interface DeviceRetrieveService {
    List<DeviceModel> findAll();

    DeviceModel getById(String id);

    DeviceModel update(DeviceModel model);
    Device updateDevice(Device device) ;
    void delete(String id);
}
