package com.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamel {

	public static void main(String[] args) {
		
		// define the camel context
		CamelContext context = new DefaultCamelContext();
		
		// need to add route
		try {
			context.addRoutes(new RouteBuilder() {
				
				@Override
				public void configure() throws Exception {
					from("file:data/input?noop=true")
					    .to("file:data/output");
				}
			});
			
			// start the context so it will start the route
			context.start();
			
			// need to put the time between start and stop
			Thread.sleep(5000);
			
			// stop the route
			context.stop();
			
		} catch (Exception e) {
			System.out.println("Exception is :"+e);
			
			e.printStackTrace();
		}
	}
}
