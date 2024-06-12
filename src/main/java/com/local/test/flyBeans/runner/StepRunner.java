package com.local.test.flyBeans.runner;

import com.local.test.context.RequestContext;
import com.local.test.flyBeans.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class StepRunner {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private RequestContext requestContext;

    @Qualifier("taskExecutor")
    @Autowired
    private Executor taskExecutor;

    List<String> stepNames = Arrays.asList("Step1", "Step2", "Step3", "Step4", "Step5", "Step6");


    public void runSteps() {
        System.out.println("Inicio de runSteps");
        Map<String, String> mapContext = requestContext.getStepMap();

        Executor executor = Executors.newFixedThreadPool(1);

        CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Inicio de CompletableFuture");
                RequestContext localRequestContext = new RequestContext();
                localRequestContext.setStepMap(mapContext);
                for (String stepName : stepNames) {

                    Step step = (Step) context.getBean(stepName);
                    if (step == null) {
                        System.out.println("Bean not found for: " + stepName);
                    } else {
                        step.setRequestContext(localRequestContext);

                        step.print();
                    }

                }
                System.out.println("Fin de CompletableFuture");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception in CompletableFuture: " + e.getMessage());
            }
        }, executor);
        System.out.println("Fin de runSteps");
    }


    public void runStepsBatch() {
        for (String stepName : stepNames) {
            Step step = (Step) context.getBean(stepName);
            step.print();
        }

    }
}
