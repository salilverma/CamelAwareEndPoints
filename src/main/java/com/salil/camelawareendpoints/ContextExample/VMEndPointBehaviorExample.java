package com.salil.camelawareendpoints.ContextExample;

import com.salil.camelawareendpoints.router.VMEndPoint1stRouter;
import com.salil.camelawareendpoints.router.VMEndPoint2ndRouter;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by Salil on 29-02-2016.
 */
public class VMEndPointBehaviorExample {

    public static void main(String[] args) throws Exception {
        CamelContext firstCamelContext = new DefaultCamelContext();
        firstCamelContext.addRoutes(new VMEndPoint1stRouter());
        firstCamelContext.start();

        CamelContext secondCamelContext = new DefaultCamelContext();
        secondCamelContext.addRoutes(new VMEndPoint2ndRouter());
        secondCamelContext.start();

        ProducerTemplate producerTemplate=firstCamelContext.createProducerTemplate();
        producerTemplate.sendBody(VMEndPoint1stRouter.VM_START, "Initial Message");

        Thread.sleep(2000);
    }
}
