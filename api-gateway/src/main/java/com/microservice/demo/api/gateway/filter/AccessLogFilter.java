package com.microservice.demo.api.gateway.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessLogFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

		logger.info(
				"REQUEST :: < " + request.getScheme() + " " + request.getLocalAddr() + ":" + request.getLocalPort());
		logger.info(
				"REQUEST :: < " + request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol());
		logger.info("RESPONSE:: > HTTP: " + response.getStatus());
		logger.info("RESPONSE:: > Content-Type: " + response.getContentType());

		try (final InputStream responseDataStream = RequestContext.getCurrentContext().getResponseDataStream()) {
			final String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
			logger.info("RESPONSE:: > Body: " + responseData);
			RequestContext.getCurrentContext().setResponseBody(responseData);
		} catch (IOException e) {
			logger.warn("Error reading body", e);
		}

		// TODO - Log the message as a JSON

		return null;
	}
}
