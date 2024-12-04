package com.example.exception.controller;

import com.example.exception.model.Api;
import com.example.exception.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

	private static List<UserResponse> userList = List.of(
			UserResponse.builder()
					.id("1")
					.name("steve")
					.age(10)
					.build()
			,
			UserResponse.builder()
					.id("2")
					.name("josh")
					.age(15)
					.build()
			,
			UserResponse.builder()
					.id("3")
					.name("james")
					.age(20)
					.build()
	);

	@GetMapping("/id/{userId}")
	public Api<UserResponse> getUser(@PathVariable String userId) {
		UserResponse user = userList.stream()
				.filter(
						it -> it.getId().equals(userId)
				).findFirst()
				.get();

		Api<UserResponse> response = Api.<UserResponse>builder()
				.resultCode(String.valueOf(HttpStatus.OK.value()))
				.resultMessage(HttpStatus.OK.name())
				.data(user)
				.build();

		return response;
	}
}
