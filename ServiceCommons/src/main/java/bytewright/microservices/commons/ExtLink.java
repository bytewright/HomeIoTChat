package bytewright.microservices.commons;


import org.springframework.hateoas.Link;

public class ExtLink {
	
	private String rel;
	private String href;
	MessageInputType inputType;
	MessageOutputType oututType;
	private String description;
	
	public ExtLink() {
		// for jackson
	}
	
	public ExtLink(final Link link, MessageInputType inputType, MessageOutputType oututType, final String description) {
		this.rel = link.getRel();
		this.href = link.getHref();
		this.inputType = inputType;
		this.oututType = oututType;
		this.description = description;
	}
	
	public MessageInputType getInputType() {
		return inputType;
	}

	public void setInputType(MessageInputType inputType) {
		this.inputType = inputType;
	}

	public MessageOutputType getOututType() {
		return oututType;
	}

	public void setOututType(MessageOutputType oututType) {
		this.oututType = oututType;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRel() {
		return rel;
	}
	
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
	
	public String getHref() {
		return href;
	}
}
