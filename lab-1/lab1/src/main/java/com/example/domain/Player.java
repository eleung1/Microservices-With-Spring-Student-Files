package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player
{
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String position;
  
  public Player()
  {
    
  }
  
  public Player(String name, String position)
  {
    super();
    this.name = name;
    this.position = position;
  }
  
  public long getId()
  {
    return id;
  }
  public void setId(long id)
  {
    this.id = id;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getPosition()
  {
    return position;
  }
  public void setPosition(String position)
  {
    this.position = position;
  }
  
  
}
