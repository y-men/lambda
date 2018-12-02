package io.demo.services;


import com.googlecode.jmapper.JMapper;
import io.core.annotations.TraceExecutionTime;
import io.core.annotations.TraceMethod;
import io.demo.domain.Device;
import io.demo.model.DeviceModel;
import io.demo.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeviceRetrieveServiceImpl implements DeviceRetrieveService {

    DeviceRepository deviceRepository;
    JMapper<DeviceModel, Device> deviceModelDeviceJMapper;
    JMapper<Device, DeviceModel> deviceDeviceModelJMapper;


    public DeviceRetrieveServiceImpl(DeviceRepository deviceRepository,
                                     JMapper<DeviceModel, Device> deviceModelDeviceJMapper,
                                     JMapper<Device, DeviceModel> deviceDeviceModelJMapper

                                     ) {
        this.deviceRepository = deviceRepository;
        this.deviceModelDeviceJMapper = deviceModelDeviceJMapper;
        this.deviceDeviceModelJMapper = deviceDeviceModelJMapper;
    }

    @TraceMethod
    @TraceExecutionTime
    @Override
    public List<DeviceModel> findAll() {
        List<DeviceModel> devices = new ArrayList<>();
        deviceRepository.findAll().forEach(device -> {
            DeviceModel deviceModel  = deviceModelDeviceJMapper.getDestination(device);
            devices.add( deviceModel);

        });
        return devices;
    }

    @Override
    public DeviceModel getById(String id) {
        return null;
    }

    @Override
    public Device updateDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public DeviceModel update(DeviceModel deviceModel) {
        Device device = deviceDeviceModelJMapper.getDestination(deviceModel);
        deviceRepository.save(device);
        return deviceModelDeviceJMapper.getDestination(device);
    }


    @Override
    public void delete(String id) {

    }
}
