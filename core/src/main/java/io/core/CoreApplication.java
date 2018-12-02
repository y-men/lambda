package io.core;

import io.core.beans.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CoreApplication implements CommandLineRunner {

    @Autowired
    Business business;

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // todo Refactor to TestCase
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" >> " + business.getDescription());
        System.out.println(" >> " + business.getName());
        business.retrieveCustomData("aaa",111, true);
    }



}