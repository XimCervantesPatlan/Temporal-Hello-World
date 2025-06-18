package com.ibm;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface HelloWorldActivities {

    String sayHello(String name);
}
