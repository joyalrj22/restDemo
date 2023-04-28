package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DemoApplicationTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testNoContent() throws Exception {
	}

	@Test
	public void testWithoutBearerToken() throws Exception {
	}

	@Test
	public void testEchoValid() throws Exception {
	}

	@Test
	public void testDeviceValid() {
	}

	@Test
	// Check the database doesn't store duplicates
	public void testSameEntrySubmittedTwice() {
	}

	@Test
	public void testSubmitTwoDifferent() {
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
