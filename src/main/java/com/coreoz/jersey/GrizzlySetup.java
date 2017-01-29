package com.coreoz.jersey;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Configure and start a Grizzly server
 */
public class GrizzlySetup {

	private static final int DEFAULT_HTTP_PORT = 8080;
	private static final String DEFAULT_HTTP_HOST = "0.0.0.0";

	public static void start(ResourceConfig jerseyResourceConfig, String httpPort, String httpHost)
			throws IOException {
		int httpPortToUse = httpPort == null ? DEFAULT_HTTP_PORT : Integer.parseInt(httpPort);
		String httpHostToUse = httpHost == null ? DEFAULT_HTTP_HOST : httpHost;

		// create the server
		URI baseUri = UriBuilder.fromUri("http://"+httpHostToUse+"/api").port(httpPortToUse).build();
		HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(
			baseUri,
			jerseyResourceConfig,
			// the server have to be started after the configuration is complete,
			// else the custom error page generator won't be used
			false
		);

		httpServer.start();
	}

}

