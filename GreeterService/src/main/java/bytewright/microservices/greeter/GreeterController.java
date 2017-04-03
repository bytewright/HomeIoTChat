package bytewright.microservices.greeter;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import bytewright.microservices.commons.Message;
import bytewright.microservices.commons.MessageInputType;
import bytewright.microservices.commons.MessageOutputType;
import bytewright.microservices.commons.HateoasOverview;

@RestController
public class GreeterController {
	static final Logger LOG = Logger.getLogger(GreeterController.class.getName());
	
	@Inject
	RestTemplate restTemplate;
	
    @RequestMapping("/greeting")
    public ResponseEntity<Message> greeting() {
        String answer = "Hello from EurekaClient!";

		return new ResponseEntity<>(new Message(answer), HttpStatus.OK);
    }
    
	@RequestMapping(value="/info", produces="application/json")
	public HateoasOverview index() {
	final HateoasOverview index = new HateoasOverview("greeter", "desc");
	index.addLink(ControllerLinkBuilder.linkTo(
	ControllerLinkBuilder.methodOn(GreeterController.class).greeting()), 
			MessageInputType.SERVICE_CALL, MessageOutputType.CHAT_RESPONSE, "desc");
	return index;
	}
}
