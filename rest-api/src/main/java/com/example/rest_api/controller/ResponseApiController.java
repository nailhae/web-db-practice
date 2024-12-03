package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

	@GetMapping("")
	public ResponseEntity<UserRequest> user() {
		UserRequest user = new UserRequest();
		user.setUserName("steve");
		user.setUserAge(10);

		return ResponseEntity.ok(user);
	}
}
