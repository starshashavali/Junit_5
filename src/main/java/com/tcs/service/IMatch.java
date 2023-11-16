package com.tcs.service;

import com.tcs.dto.CrecketDTO;

public interface IMatch {

	public String saveTeam(CrecketDTO CrecketDTO);

	public CrecketDTO getTeam(String playerId);

}
