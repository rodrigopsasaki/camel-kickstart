package com.apache.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }

    public void execute(){
        CamelContext context = new DefaultCamelContext();
        try {
            context.addRoutes(new MyFileRouteBuilder());
            context.start();
            Thread.sleep(3000);
            context.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
