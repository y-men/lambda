package io.device.reactive.config;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import io.device.reactive.domain.Device;
import io.device.reactive.model.DeviceModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.googlecode.jmapper.api.JMapperAPI.global;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

@Configuration
public class ModelConfiguration {

    @Bean
    public JMapper<DeviceModel, Device> deviceModelDeviceJMapper () {
        JMapperAPI jmapperApi = new JMapperAPI()
                .add(mappedClass(DeviceModel.class).add(global())) ;
        JMapper<DeviceModel, Device> deviceJMapper = new JMapper<>(DeviceModel.class, Device.class,jmapperApi);
        return  deviceJMapper;

    }
}
