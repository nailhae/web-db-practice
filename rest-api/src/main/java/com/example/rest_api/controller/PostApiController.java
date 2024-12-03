package com.example.rest_api.controller;

import com.example.rest_api.model.BookRequest;
import com.example.rest_api.model.ContactRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostApiController {

	@PostMapping("/post")
	public void post(@RequestBody BookRequest bookRequest) {
		System.out.println("post method");
	}

	@PostMapping("/contact")
	public void contact(@RequestBody ContactRequest contactRequest) {
		System.out.println(contactRequest.toString());
	}
}
