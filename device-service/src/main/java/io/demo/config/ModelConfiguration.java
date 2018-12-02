package io.demo.config;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import io.demo.domain.Device;
import io.demo.model.DeviceModel;
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

    @Bean
    public JMapper< Device,DeviceModel> deviceDeviceModelJMapper () {
        JMapperAPI jmapperApi = new JMapperAPI()
                .add(mappedClass(DeviceModel.class).add(global())) ;
        JMapper< Device,DeviceModel> deviceModelJMapper = new JMapper<>( Device.class,DeviceModel.class,jmapperApi);
        return  deviceModelJMapper;

    }
}
