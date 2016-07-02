package com.example;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that generates a subject for the sentence.
 * 
 * @author Eric Leung
 *
 */
@RestController
public class SubjectController
{
  @Value("${words}")
  private String words;
  
  @RequestMapping("/")
  public @ResponseBody String getWord()
  {
    String[] wordArray = words.split(",");
    int i = getRandom(0, wordArray.length);
    return wordArray[i];
  }
  
  /**
   * Helper method to generate a random number between low(inclusive) and high(exclusive)
   * 
   * @param low
   * @param high
   * @return
   */
  public int getRandom(int low, int high)
  {
    Random r = new Random();
    return r.nextInt(high-low) + low;
  }
}
