package demo;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
@EnableZuulProxy
public class Application
{

  public static void main(String[] args)
  {
    SpringApplication.run(Application.class, args);
  }

  /**
   * Use shallow etag to eliminate the need to send a payload to the client when
   * nothing has changed
   * 
   * @return
   */
  @Bean
  public Filter shallowEtagHeaderFilter()
  {
    return new ShallowEtagHeaderFilter();
  }
}
