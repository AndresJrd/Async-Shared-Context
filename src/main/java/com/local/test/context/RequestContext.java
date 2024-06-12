package com.local.test.context;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@RequestScope
public class RequestContext {
    private Map<String, String> stepMap = Collections.synchronizedMap(new HashMap<>());

    public void setStep(String stepName, String action) {
        stepMap.put(stepName, action);
    }

    public String getStepValue(String stepName) {
        return stepMap.getOrDefault(stepName, null);
    }

    public Set<String> getNames() {
        return stepMap.keySet();
    }

    public Map<String,String> getStepMap(){
        return Collections.synchronizedMap(new HashMap<>(stepMap));
    }

    public void setStepMap(Map<String, String> map){
        this.stepMap =Collections.synchronizedMap(new HashMap<>(map));
    }
}
