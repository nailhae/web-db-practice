package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

//	@NotBlank
	private String name;

	private String nickname;


	@Size(min = 1, max = 12)
	@NotBlank
	private String password;

	@NotNull
	@Min(1)
	@Max(100)
	private Integer age;

	@Email
	private String email;

//	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "xxx-xxxx-xxxx or xxxx-xxx")
	@PhoneNumber
	private String phoneNumber;

	@PastOrPresent
	private LocalDateTime registerAt;

	@YearMonth(pattern = "yyyyMM")
	private String birthDayYearMonth;

	@AssertTrue(message = "name or nickName 은 존재해야 합니다.")
	public boolean nameCheck() {

		if (!name.isBlank()) {
			return true;
		}

		if (!nickname.isBlank()) {
			return true;
		}

		return false;
	}
}