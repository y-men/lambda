package io.demo;

//import io.core.annotations.TraceExecutionTime;
//import io.core.annotations.TraceMethod;
import io.demo.bootstrap.BootstrapDevices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceApplicationTests {

    @Autowired
     BootstrapDevices bootstrapDevices;

    @Before
    public void before(){
//        bootstrapDevices.bootstrapMockData();
    }


    @Test
    public void contextLoads() {
    }

}
