package io.demo.repositories;

import io.demo.domain.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device,String> {
}
