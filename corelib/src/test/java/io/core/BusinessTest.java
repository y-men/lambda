package io.core;

import io.core.beans.Business;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableAspectJAutoProxy
public class BusinessTest {

    @Autowired
    Business business;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAnnotations() {
        System.out.println("-------- testAnnotations -----------------------------------");
        System.out.println(" >> " + business.getDescription());
        System.out.println(" >> " + business.getName());
        business.retrieveCustomData("aaa",111, true);    }
}

