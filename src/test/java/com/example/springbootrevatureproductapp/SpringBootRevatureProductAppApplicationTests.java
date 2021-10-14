package com.example.springbootrevatureproductapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringBootRevatureProductAppApplicationTests {

	@LocalServerPort
	private String port;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String baseUrl = "http://localhost";
	
	private URL url;
	
	@BeforeEach
	public void setUp() throws MalformedURLException {
		url = new URL(baseUrl + ":" + port);
	}
	
	@Test
	@DisplayName("Testing home")
	public void contextLoads() throws MalformedURLException {
		
		ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), String.class);
		
		assertEquals("Welcome to Revature", response.getBody());
	}
	
	
	@Test
	@DisplayName("Testing message")
	public void testMessageAPI() throws MalformedURLException {
		
		ResponseEntity<String> response = restTemplate.getForEntity(url.toString().concat("/message"), String.class);
		
		assertEquals("--Revature Training App--", response.getBody());
	}
	
	@Test
	@DisplayName("Testing dummy page")
	public void testDummyPage() throws MalformedURLException {
		
		ResponseEntity<String> response = restTemplate.getForEntity(url.toString().concat("/dummy"), String.class);
		assertEquals("This is the dummy page", response.getBody());
	}

}
