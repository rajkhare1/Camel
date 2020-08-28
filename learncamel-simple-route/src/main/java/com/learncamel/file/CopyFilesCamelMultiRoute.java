package com.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamelMultiRoute {

	public static void main(String[] args) {
		
		// create the context
		CamelContext context = new DefaultCamelContext();
		
		
		// add the route
		try {
			context.addRoutes(new RouteBuilder() {
				
				@Override
				public void configure() throws Exception {
					// configure route
					from("file:data/input?noop=true")
					.to("log:?level=INFO&showHeaders=true&showBody=true")
					.to("file:data/output")
				.to("file:data/anotheroutput");
					
					from("file:data/input1?noop=true")
					.to("file:data/output1");
					
				}
			});
			
			// start the context
			context.start();
			
			// time delay to stop
			Thread.sleep(5000);
			
			// stop the context
			context.stop();
			
		} catch (Exception e) {
			System.out.println("Inside the Exception::::");
			e.printStackTrace();
		}
		
		
		

	}

}
