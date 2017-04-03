package bytewright.microservices.registry.service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.eureka.registry.InstanceRegistry;

import bytewright.microservices.commons.HateoasOverview;

@Service
public class ServiceRegistry {
	private final InstanceRegistry instanceRegistry;
    private final RestTemplate restTemplate;
    
    public ServiceRegistry(
    		final InstanceRegistry instanceRegistry,
    		final RestTemplate restTemplate) {
    	this.instanceRegistry = instanceRegistry;
    	this.restTemplate = restTemplate;
	}
    
    public Collection<HateoasOverview> getAll() {
    	return instanceRegistry.getApplications().getRegisteredApplications().stream()
    			.map(a -> buildOverview(a))
    			.collect(Collectors.toList());
    }
    
    public Optional<HateoasOverview> getOverview(final String name) {
    	final Application app = instanceRegistry.getApplications().getRegisteredApplications(name.toUpperCase());
    	return app == null ? Optional.empty() : Optional.of(buildOverview(app));
    }

	private HateoasOverview buildOverview(Application app) {
		final InstanceInfo info = app.getInstances().iterator().next();
		return this.restTemplate.getForObject(info.getHomePageUrl(), HateoasOverview.class);
	}
}
