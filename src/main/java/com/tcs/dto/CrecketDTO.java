package com.tcs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrecketDTO {

	private String playerId;

	@NotBlank(message = "Player name cannot be blank")
	private String playerName;

	@NotNull(message = "Age cannot be null")
	@Positive(message = "Age must be a positive number")
	private Integer age;

	@NotBlank(message = "Role cannot be blank")
	private String role;

	@NotBlank(message = "Batting style cannot be blank")
	private String battingStyle;

	@NotBlank(message = "Bowling style cannot be blank")
	private String bowlingStyle;

}
