package bytewright.microservices.greeter;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class GreeterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreeterServiceApplication.class, args);
    }

    
	@Bean
	public RestTemplate restTemplate(){
		MappingJackson2HttpMessageConverter json = new MappingJackson2HttpMessageConverter();
		return new RestTemplate(Collections.singletonList(json));
	}
}