package com.coreoz.jersey;

import java.io.IOException;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;

public class WebApplication {

	public static void main(String[] args) throws IOException {
		ResourceConfig config = new ResourceConfig();
		config.register(WebService.class);
		config.register(new AbstractBinder() {
			@Override
			protected void configure() {
				bindFactory(HttpInfosFactory.class).to(HttpInfos.class).in(RequestScoped.class);
			}
		});

		// starts the server
		GrizzlySetup.start(
			config,
			System.getProperty("http.port"),
			System.getProperty("http.address")
		);
	}

}
