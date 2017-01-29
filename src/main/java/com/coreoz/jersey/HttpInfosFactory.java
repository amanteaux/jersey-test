package com.coreoz.jersey;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;

import org.glassfish.hk2.api.Factory;

public class HttpInfosFactory implements Factory<HttpInfos> {

	private final ContainerRequestContext context;

	@Inject
	public HttpInfosFactory(ContainerRequestContext context) {
		this.context = context;
	}

	@Override
	public HttpInfos provide() {
		return new HttpInfos(context.getHeaders());
	}

	@Override
	public void dispose(HttpInfos arg0) {
	}

}

