package com.ibm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private WorkflowClient workflowClient;

    @GetMapping("/{name}")
    public String greet(@PathVariable String name){
        HelloWorldWorkflow workflow = workflowClient.newWorkflowStub(
            HelloWorldWorkflow.class,
            WorkflowOptions.newBuilder()
                            .setTaskQueue("HELLO_TASK_QUEUE").build()
        );
        return workflow.getGreetings(name);

    }
}
