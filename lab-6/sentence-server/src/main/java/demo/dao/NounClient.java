package demo.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.domain.Word;

@FeignClient("noun")
public interface NounClient
{
  // The @RequestMapping tells feign we need to make an HTTP GET call
  // to the NOUN service's / path, i.e. http://[NOUN service]/
  @RequestMapping(value="/", method=RequestMethod.GET)
  public Word getWord();
}
