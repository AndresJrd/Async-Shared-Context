package com.local.test.flyBeans;

import com.local.test.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("Step4")
public class Step4 implements Step {


    private RequestContext requestContext;

    @Override
    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }
    @Override
    public void print() {
        try {
            Thread.sleep(70);
        } catch (InterruptedException ec){
            System.out.println("Error sleep");
        }
        requestContext.setStep(this.getClass().getSimpleName(), new Date() +" Step4");
        System.out.println("Current: Step4 previous::" + requestContext.getStepValue("Step3")+ "   total:" + requestContext.getNames().size());
    }
}
