package io.demo.bootstrap;

import io.demo.domain.Device;
import io.demo.services.DeviceRetrieveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class BootstrapDevices implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    DeviceRetrieveService deviceRetrieveService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       // bootstrapMockData();
    }

    public void bootstrapMockData() {
        Object[][] names = {
                {"Apple", "My Personal mobile device", false, 0D, 5.1D, 8.2D},
                {"OnePlus", "My work mobile", false, 4D, 4.5D, 7.2D},
                {"Samsung Galaxy S", "A mobile that is used for gaming", false, 6D, 7.1D, 9.2D},
                {"Huawei", "A backup mobile for travel", false, 0D, 8.1D, 8.2D},
                {"Xiaomi", "An additional mobile", false, 0D, 5.1D, 1.5D},

        };
        Arrays.stream(names).forEach(a -> {
            Device d = new Device();
            d.setName((String) a[0]);
            d.setDesc((String) a[1]);
            d.setToggle((Boolean) a[2]);
            d.setReceptionLevel((Double) a[3]);
            d.setHardwareVersion((Double) a[4]);
            d.setSoftwareVersion((Double) a[5]);
            deviceRetrieveService.updateDevice(d);
        });


    }


}
