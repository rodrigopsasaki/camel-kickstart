package com.rodrigosasaki.java8.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.GenericFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author rodrigo.sasaki@icarros.com.br
 */
public class MyFileRouteBuilder extends RouteBuilder {



    @Override
    public void configure() throws Exception {
        from("file:/home/rodrigo/camel/input")
                .process(new FileNameProcessor())
                .to("file:/home/rodrigo/camel/output")
                .end();
    }

}

class FileNameProcessor implements Processor{

    Logger logger = LoggerFactory.getLogger(FileNameProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();
        if(body instanceof GenericFile){
            GenericFile file = (GenericFile) body;
            logger.info("Moving file: " + file.getFileName());
        }
    }

}
