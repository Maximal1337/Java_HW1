import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum MessageCategory {WORK, PERSONAL, SPAM, PROMOTIONS, SOCIAL}

public abstract class Message {
	private String sender;
	private String content;
	private Date sendDate;
	private MessageCategory category;
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) throws IllegalArgumentException{
		if(sender == null || sender.trim().isEmpty()) throw new IllegalArgumentException("sender cant be null or empty");
		this.sender = sender;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) throws IllegalArgumentException {
		if(content == null || content.trim().isEmpty()) throw new IllegalArgumentException("content cant be null or empty");
		this.content = content;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	public MessageCategory getMessageCategory() {
		return category;
	}
	    
	public void setMessageCategory(MessageCategory category) throws IllegalArgumentException {
		if(category == null) throw new IllegalArgumentException("category cant be null");
		this.category = category;
	}
	
	public Message(String sender, String content, MessageCategory category) {
		setSender(sender);
		setContent(content);
		setSendDate(new Date(System.currentTimeMillis()));
		setMessageCategory(category);
	}
	public Message(String sender, String content, Date sendDate, MessageCategory category) {
		this(sender,  content,  category);
		setSendDate(sendDate);
	}
	
	@Override
	public String toString() {
		return "Sender: " + getSender() + ", content: " + getContent() + ", sendDate: " + getSendDate().toString() + ", category: " + getMessageCategory();
	}
	
	public Boolean find(ArrayList<String> keywords) {
		String[] contentArr = content.replaceAll("[,.!?;:\"'()\\[\\]{}\\-_/\\\\]", "").strip().trim().toLowerCase().split("\\s+");  // \s+ handles multiple spaces
		List<String> contentList = Arrays.asList(contentArr);
		for(String keyword : keywords) {
			if(contentList.contains(keyword.strip().trim().toLowerCase())) return true;
		}
		return false;
	}
	
//	Implemented one new method
	public void printlnToString() {
		System.out.println(this.toString());
	}
//	Method for BoardMessage
	public abstract String generatePreview();
}
