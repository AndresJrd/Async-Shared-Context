package com.local.test.flyBeans;

import com.local.test.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("Step2")
public class Step2 implements Step {


    private RequestContext requestContext;

    @Override
    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }
    @Override
    public void print() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException ec){
            System.out.println("Error sleep");
        }
        requestContext.setStep(this.getClass().getSimpleName(), new Date() +" Step2");
        System.out.println("Current: Step2 previous:" + requestContext.getStepValue("Step1")+ "    total:" + requestContext.getNames().size());
    }
}
