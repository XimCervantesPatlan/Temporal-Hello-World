package com.ibm;

public class HelloWorldActivitiesImpl implements HelloWorldActivities{

    @Override
    public String sayHello(String name) {
        return "Hola " + name + "!";    
    }

}
