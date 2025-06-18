package com.ibm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

@Configuration
public class WorkerStarter {

    @Bean
    public WorkflowServiceStubs workflowServiceStubs(){
        return WorkflowServiceStubs.newInstance();
    }

    @Bean
    public WorkflowClient workflowClient (WorkflowServiceStubs service){
        return WorkflowClient.newInstance(service);
    }

    @Bean
    public WorkerFactory workerFactory(WorkflowClient client){
        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker("HELLO_TASK_QUEUE");
        
        worker.registerWorkflowImplementationTypes(HelloWorldWorkflowImpl.class);
        worker.registerActivitiesImplementations(new HelloWorldActivitiesImpl());
        return factory;
    }
}
