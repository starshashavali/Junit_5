package com.tcs.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.domain.Cricket;
import com.tcs.dto.CrecketDTO;
import com.tcs.service.IMatch;

@WebMvcTest
public class TestPlayerRestController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IMatch imatch;
	
	public static final String convertObjToJson(final Object obj) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		return mapper.writeValueAsString(obj);
		
	}
	
	@Test
	void testSave() throws Exception {
		CrecketDTO dto = new CrecketDTO("p001", " Siva", 23, "Batsman", "left hand", "Right-hand");
		Cricket entity = new Cricket("p001", " Siva", 23, "Batsman", "left hand", "Right-hand");
		
		
		when(imatch.saveTeam(dto)).thenReturn("Successfully saved...");
		
		mockMvc.perform(post("/playerapi/save").contentType(MediaType.APPLICATION_JSON)
				.content(convertObjToJson(dto))
				).andExpect(status().isCreated());
		
	}
	
	@Test
	void testGetTeam() throws Exception {
		CrecketDTO dto = new CrecketDTO("p001", " Siva", 23, "Batsman", "left hand", "Right-hand");
		Cricket entity = new Cricket("p001", " Siva", 23, "Batsman", "left hand", "Right-hand");
		when(imatch.getTeam(dto.getPlayerId())).thenReturn(dto);
		
		mockMvc.perform(get("/playerapi/{playerId}",dto.getPlayerId()))
		.andExpect(status().isOk());
				
				
		
	}

}
