package com.local.test.controller;


import com.local.test.flyBeans.runner.StepRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StepController {

    @Autowired
    private StepRunner stepRunner;

    @GetMapping("/run-steps")
    public String runSteps() {
        stepRunner.runSteps();
        return "Steps executed";
    }
    @GetMapping("/run-steps-batch")
    public String runStepsBatch() {
        stepRunner.runStepsBatch();
        return "Steps executed";
    }
}
