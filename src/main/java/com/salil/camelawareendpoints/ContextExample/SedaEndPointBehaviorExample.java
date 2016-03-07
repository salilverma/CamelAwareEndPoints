package com.salil.camelawareendpoints.ContextExample;

import com.salil.camelawareendpoints.router.SedaEndPointRouter;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by Salil on 29-02-2016.
 */
public class SedaEndPointBehaviorExample {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new SedaEndPointRouter());
        camelContext.start();

        ProducerTemplate producerTemplate=camelContext.createProducerTemplate();
        producerTemplate.sendBody(SedaEndPointRouter.SEDA_START, "Initial Message");

        Thread.sleep(2000);
    }
}
