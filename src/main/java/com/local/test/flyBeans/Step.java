package com.local.test.flyBeans;

import com.local.test.context.RequestContext;

public interface Step {

    void print();

    void setRequestContext(RequestContext requestContext);
}
