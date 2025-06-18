package com.ibm;

import java.time.Duration;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

public class HelloWorldWorkflowImpl implements HelloWorldWorkflow{

    private final HelloWorldActivities activities = Workflow.newActivityStub(
        HelloWorldActivities.class,
        ActivityOptions.newBuilder()
                        .setStartToCloseTimeout(Duration.ofSeconds(3))    
                        .build()
        );
    @Override
    public String getGreetings(String name) {
        return activities.sayHello(name);
    }

}
