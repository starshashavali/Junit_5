package com.tcs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.domain.Cricket;

public interface CricketRepo  extends JpaRepository<Cricket, Integer>{

	Optional<Cricket> findByPlayerId(String playerId);


}
