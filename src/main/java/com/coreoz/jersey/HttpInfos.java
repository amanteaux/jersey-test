package com.coreoz.jersey;

import java.util.List;
import java.util.Map;

public class HttpInfos {

	private final Map<String, List<String>> headers;

	public HttpInfos(Map<String, List<String>> headers) {
		this.headers = headers;
	}

	public Map<String, List<String>> getHeaders() {
		return headers;
	}

}
