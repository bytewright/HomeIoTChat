package bytewright.microservices.commons;

import java.util.Arrays;
import java.util.List;

public class Message {
	
	private List<String> messages;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(List<String> messages) {
		this.messages = messages;
	}
	
	public Message(String... lines) {
		this.messages = Arrays.asList(lines);
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public List<String> getMessages() {
		return messages;
	}

}
