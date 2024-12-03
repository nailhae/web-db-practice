package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@GetMapping("/hello")
	public String hello() {
		String html = "<h1>Hello world!!!!!!!!</h1>";
		return html;
	}

	@GetMapping("/echo/{message}/age/{age}/is-man/{isMan}")
	public String echo(
			@PathVariable(name = "message") String msg
			, @PathVariable int age
			, @PathVariable boolean isMan
	) {
		System.out.println("echo message : " + msg);
		System.out.println("echo age : " + age);
		System.out.println("echo isMan : " + isMan);

		return msg;

		// http://localhost:8080/api/echo/timo/age/20/is-man/true
	}


	@GetMapping("/book")
	public void queryParam(BookQueryParam bookQueryParam) {
		System.out.println(bookQueryParam);

		// http://localhost:8080/api/book?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
	}

	@GetMapping("/plus")
	public int plus(
			@RequestParam int num1
			, @RequestParam int num2
	) {
		return num1 + num2;
		// http://localhost:8080/api/plus?num1=10&num2=20
	}

	@GetMapping("/multi")
	public int multi(
			@RequestParam int num1
			, @RequestParam int num2
	) {
		return num1 * num2;
		// http://localhost:8080/api/multi?num1=10&num2=20
	}

}