package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Player;
import com.example.domain.Team;
import com.example.repository.TeamRepository;

@SpringBootApplication
public class Lab1Application
{
  @Autowired
  private TeamRepository teamRepository;
  
  public static void main(String[] args)
  {
    SpringApplication.run(Lab1Application.class, args);
  }
  
  @PostConstruct
  public void init()
  {
    Player player1 = new Player("Player1", "Mid");
    Player player2 = new Player("Player2", "Forward");
    Player player3 = new Player("Player3", "Defense");
    Player player4 = new Player("Player4", "Goalie");
    
    Set<Player> playerSet1 = new HashSet<Player>();
    playerSet1.add(player1);
    playerSet1.add(player2);
    
    Set<Player> playerSet2 = new HashSet<Player>();
    playerSet2.add(player3);
    playerSet2.add(player4);
    
    List<Team> teams = new ArrayList<Team>();
    Team team1 = new Team();
    team1.setLocation("City1");
    team1.setName("Team1");
    team1.setPlayers(playerSet1);
    teams.add(team1);
    
    Team team2 = new Team();
    team2.setLocation("City2");
    team2.setName("Team2");
    team2.setPlayers(playerSet2);
    teams.add(team2);
    
    teamRepository.save(teams);
  }
}
