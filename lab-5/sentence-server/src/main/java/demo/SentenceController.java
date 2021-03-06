package demo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;



@Controller
public class SentenceController {

	@Autowired 
	DiscoveryClient client;
	
	@Autowired 
	private LoadBalancerClient ribbonClient;
	
	/**
	 * Display a small list of Sentences to the caller:
	 */
	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
	  return 
		"<h3>Some Sentences</h3><br/>" +	  
		buildSentence() + "<br/><br/>" +
		buildSentence() + "<br/><br/>" +
		buildSentence() + "<br/><br/>" +
		buildSentence() + "<br/><br/>" +
		buildSentence() + "<br/><br/>"
		;
	}

	
	/**
	 * Assemble a sentence by gathering random words of each part of speech:
	 */
	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		try{
			sentence =  
				String.format("%s %s %s %s %s.",
				    getWordWithRibbon("SUBJECT"),
				    getWordWithRibbon("VERB"),
				    getWordWithRibbon("ARTICLE"),
				    getWordWithRibbon("ADJECTIVE"),
				    getWordWithRibbon("NOUN") );			
		} catch ( Exception e ) {
			System.out.println(e);
		}
		return sentence;
	}

	
	/**
	 * Obtain a random word for a given part of speech, where the part 
	 * of speech is indicated by the given service / client ID:
	 */
	public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
      	URI uri = list.get(0).getUri();
	      	if (uri !=null ) {
	      		return (new RestTemplate()).getForObject(uri,String.class);
	      	}
        }
        return null;
	}
	
	/**
	 * Lab 5 exercise:
	 * Use Ribbon client side load balancer to choose a ServiceInstance.
	 * 
	 * @param service service name
	 * @return response from the service with the provided service name.
	 */
	public String getWordWithRibbon(String service)
	{
	  ServiceInstance serviceInstance = ribbonClient.choose(service);
	  URI uri = serviceInstance.getUri();
	  return (new RestTemplate()).getForObject(uri,String.class);
	}

}
