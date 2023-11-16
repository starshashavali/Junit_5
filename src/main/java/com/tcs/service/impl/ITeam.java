package com.tcs.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.domain.Cricket;
import com.tcs.dto.CrecketDTO;
import com.tcs.exception.IdNotFoundException;
import com.tcs.repo.CricketRepo;
import com.tcs.service.IMatch;

@Service
public class ITeam implements IMatch {
	@Autowired
	private CricketRepo cricketRepo;


	

	@Override
	public String saveTeam(CrecketDTO crecketDTO) {
		Cricket entity = new Cricket();
		BeanUtils.copyProperties(crecketDTO, entity);
		cricketRepo.save(entity);
		return "Successfully saved...";
	}

	@Override
	public CrecketDTO getTeam(String playerId) {
		Optional<Cricket> optional = cricketRepo.findByPlayerId(playerId);
		if (optional.isPresent()) {
			Cricket cricket = optional.get();
			CrecketDTO dto = new CrecketDTO();
			BeanUtils.copyProperties(cricket, dto);
			return dto;
		}
		throw new IdNotFoundException("Id not found::" + playerId);
	}

}
