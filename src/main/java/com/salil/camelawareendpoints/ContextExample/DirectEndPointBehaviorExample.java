package com.salil.camelawareendpoints.ContextExample;

import com.salil.camelawareendpoints.router.DirectEndPointRouter;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by Salil on 29-02-2016.
 */
public class DirectEndPointBehaviorExample {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new DirectEndPointRouter());
        camelContext.start();

        ProducerTemplate producerTemplate=camelContext.createProducerTemplate();
        producerTemplate.sendBody(DirectEndPointRouter.DIRECT_START, "Initial Message");
    }
}
