package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.domain.Player;

@RestResource(path="playersRepo", rel="player")
public interface PlayerRepository extends CrudRepository<Player, Long>
{

}
