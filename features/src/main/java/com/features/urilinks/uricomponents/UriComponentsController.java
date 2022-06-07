package com.features.urilinks.uricomponents;

import java.io.IOException;
import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/uri-components")
public class UriComponentsController {

//	@GetMapping("/builder")
	public void uriComponentsBuilderV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UriComponents uriComponents = UriComponentsBuilder
				.fromUriString("https://example.com/hotels/{hotel}")
				.queryParam("q", "{q}")
				.encode()
				.build();
		log.info("uriComponents: {}", uriComponents);
		
		URI uri = uriComponents.expand("Westin", "v1").toUri();
		log.info("uri: {}", uri);
		
		response.getWriter().write("OK");
	}
	
	/**
	 * shorten with <pre>buildAndExpand()</pre>
	 */
//	@GetMapping("/builder")
	public void uriComponentsBuilderV2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		URI uri = UriComponentsBuilder
				.fromUriString("https://example.com/hotels/{hotel}")
				.queryParam("q", "{q}")
				.encode()
				.buildAndExpand("Westin", "v2")
				.toUri();
		log.info("uri: {}", uri);
		
		response.getWriter().write("OK");
	}
	
	/**
	 * shorten by going directly to a URI(which implies encoding)
	 */
//	@GetMapping("/builder")
	public void uriComponentsBuilderV3(HttpServletRequest request, HttpServletResponse response) throws IOException {
		URI uri = UriComponentsBuilder
				.fromUriString("https://example.com/hotels/{hotel}")
				.queryParam("q", "{q}")
				.build("Westin", "v3");
		log.info("uri: {}", uri);
		
		response.getWriter().write("OK");
	}
	
	/**
	 * shorten with full URI template
	 */
	@GetMapping("/builder")
	public void uriComponentsBuilderV4(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String requestURI = request.getRequestURI();
//		StringBuffer requestURL = request.getRequestURL();
//		log.info("host: {}", host);
//		log.info("requestURI: {} / requestURL: {}", requestURI, requestURL);
		
		URI uri = UriComponentsBuilder
				.fromUriString("https://example.com/hotels/{hotel}?q={q}")
				.build("Westin", "v4");
		log.info("uri: {}", uri);
		
		response.getWriter().write("OK");
	}
}
