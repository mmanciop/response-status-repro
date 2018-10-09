package com.example.demo;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	public void testGreetings() {
		webClient.get().uri("api/hello")
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.I_AM_A_TEAPOT);
	}

}
