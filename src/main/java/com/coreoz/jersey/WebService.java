package com.coreoz.jersey;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/test")
@Singleton
public class WebService {

	@GET
	public String test(@Context HttpInfos infos) {
		return "Here are the request headers: " + infos.getHeaders();
	}

}
