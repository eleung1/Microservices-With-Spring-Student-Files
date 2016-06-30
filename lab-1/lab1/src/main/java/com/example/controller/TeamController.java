package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

// Commented out the @RestController because we are using
// Spring Data REST to implement the controller, path is defined in the repo classes.
//@RestController
public class TeamController
{
  @Autowired
  private TeamRepository teamRepository;
  
  @RequestMapping("/teams")
  public Iterable<Team> getTeams()
  {
    return teamRepository.findAll();
  }
  
  @RequestMapping("/teams/{id}")
  public Team getTeam(@PathVariable Long id)
  {
    return teamRepository.findOne(id);
  }
}
