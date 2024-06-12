package com.local.test.flyBeans;

import com.local.test.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("Step1")
public class Step1 implements Step {


    private RequestContext requestContext;

    @Override
    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public void print() {
       // System.out.println("Iniciando Step1");
        try {
            Thread.sleep(1200);
        } catch (InterruptedException ec) {
            System.out.println("Error sleep");
        }
        requestContext.setStep(this.getClass().getSimpleName(), new Date()+" Step1");
       // System.out.println("Current: Step1 previous::" + requestContext.getStepValue("Step0") + "    total:" + requestContext.getNames().size());
      //  System.out.println("Finalizando Step1");
    }
}
