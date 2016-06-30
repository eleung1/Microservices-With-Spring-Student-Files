package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.domain.Team;

/**
 * Note: need to define the generic type of CrudRepository,
 * otherwise spring will not be able to autowire TeamRepository.
 * 
 * @author Eric Leung
 *
 */
@RestResource(path="teamsRepo", rel="team")
public interface TeamRepository extends CrudRepository<Team,Long>
{

}
