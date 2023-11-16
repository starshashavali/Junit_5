package com.tcs.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.tcs.domain.Cricket;
import com.tcs.dto.CrecketDTO;
import com.tcs.exception.IdNotFoundException;
import com.tcs.repo.CricketRepo;
import com.tcs.service.impl.ITeam;

@SpringBootTest
public class TestITeamRServiceImpl {

	@Mock
	private CricketRepo cricketRepo;

	@InjectMocks
	private ITeam iteam;

	@Test
	void testSave() {

		CrecketDTO dto = new CrecketDTO();
		Cricket entity = new Cricket();

		when(cricketRepo.save(entity)).thenReturn(entity);
		String saveTeam = iteam.saveTeam(dto);

		assertEquals(saveTeam, "Successfully saved...");
	}

	@Test
	void testGetId() {
		CrecketDTO dto = new CrecketDTO("p001", " Siva", 23, "Batsman", "left hand", "Right-hand");
		dto.setPlayerId("p001");
		Cricket entity = new Cricket("p001", " Siva", 23, "Batsman", "left hand", "Right-hand");
		when(cricketRepo.findByPlayerId("p001")).thenReturn(Optional.of(entity));
		assertEquals(iteam.getTeam(dto.getPlayerId()), dto);

	}

	@Test
	void testHandleIdNotFoundException() {
		CrecketDTO dto = new CrecketDTO();

		IdNotFoundException ex = assertThrows(IdNotFoundException.class, () -> {
			iteam.getTeam(dto.getPlayerId());
		});
		assertEquals(ex.getMessage(), "Id not found::" + dto.getPlayerId());
	}
}
