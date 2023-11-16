package com.tcs.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.dto.CrecketDTO;
import com.tcs.service.IMatch;

@RestController
@RequestMapping("/playerapi")
@Valid
public class PlayerRestController {
	
	@Autowired
	private IMatch imatch;

	@PostMapping("/save")
	public ResponseEntity<?> saveCricket(@Valid @RequestBody CrecketDTO dto) {
		String team = imatch.saveTeam(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(team);
	}

	@GetMapping("/{playerId}")
	public ResponseEntity<?> saveCricket(@Valid @PathVariable String playerId) {
		CrecketDTO dto = imatch.getTeam(playerId);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

}
