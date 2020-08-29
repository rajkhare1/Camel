package com.learncamel.file;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

public class CopyFilesRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		RouteDefinition definition = from("file:data/input?noop=true")
		    .to("log:?level=INFO&showHeader=true&showBody=true")
		    .to("file:data/output");
		
	}

}
