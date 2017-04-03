package bytewright.microservices.commons;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class HateoasOverview {
	
	private String name;
	private String description;
	private Collection<ExtLink> links;
	
	public HateoasOverview() {
		// for jackson
	}
	
	public HateoasOverview(final String name, final String description, final ExtLink... links) {
		this.name = name;
		this.description = description;
		this.links = new ArrayList<ExtLink>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setLinks(Collection<ExtLink> links) {
		this.links = links; 
	}
	
	public Collection<ExtLink> getLinks() {
		return links;
	}

	public void addLink(ControllerLinkBuilder linkTo, MessageInputType inputType, MessageOutputType oututType,
			String string) {
		this.links.add(new ExtLink(linkTo.withSelfRel(), inputType, oututType, description));
	}
}
