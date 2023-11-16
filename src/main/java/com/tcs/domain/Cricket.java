package com.tcs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Crick_tbl")
public class Cricket {
	@Id
	private String playerId;
	private String playerName;
	private Integer age;
	private String role;
	private String battingStyle;
	private String bowlingStyle;
}
