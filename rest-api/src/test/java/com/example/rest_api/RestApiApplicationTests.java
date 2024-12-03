package com.example.rest_api;

import com.example.rest_api.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		UserRequest user = new UserRequest();
		user.setUserName("steve");
		user.setUserAge(10);
		user.setEmail("ste@mail.com");
		user.setIsKorean(true);

		String json = objectMapper.writeValueAsString(user);
		System.out.println(json);

		UserRequest dto = objectMapper.readValue(json, UserRequest.class);
		System.out.println("dto");
	}

}
