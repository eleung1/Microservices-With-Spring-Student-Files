package com.example;

import org.junit.Before;
import org.junit.Test;

public class SubjectControllerTest
{
  private SubjectController testSubject;
  
  @Before
  public void setup()
  {
    testSubject = new SubjectController();
  }
  
  @Test
  public void testGetRandom()
  {
    System.out.println(testSubject.getRandom(0, 3));
    System.out.println(testSubject.getRandom(0, 3));
    System.out.println(testSubject.getRandom(0, 3));
    System.out.println(testSubject.getRandom(0, 3));
    System.out.println(testSubject.getRandom(0, 3));
    System.out.println(testSubject.getRandom(0, 3));
    System.out.println(testSubject.getRandom(0, 3));
    System.out.println(testSubject.getRandom(0, 3));
    System.out.println(testSubject.getRandom(0, 3));
    System.out.println(testSubject.getRandom(0, 3));
    
  }
}
