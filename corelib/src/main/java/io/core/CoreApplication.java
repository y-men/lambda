package io.core;

import io.core.beans.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
public class CoreApplication  {

    @Autowired
    Business business;

    public static void main(String[] args) throws Exception {
       CoreApplication coreApplication = new CoreApplication();
       coreApplication.run();
    }

    public void run() throws Exception {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" >> " + business.getDescription());
        System.out.println(" >> " + business.getName());
        business.retrieveCustomData("aaa",111, true);
    }



}