import java.sql.Date;
import java.util.ArrayList;


public class EmailMessage extends Message implements IDigital {
	private String subject;
	private ArrayList<File> attachments;
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) throws IllegalArgumentException{
		if(subject == null || subject.trim().isEmpty()) throw new IllegalArgumentException("subject cant be null or empty");
		this.subject = subject;
	}
	
	public ArrayList<File> getAttachments() {
		return attachments;
	}
	
	public void setAttachments(ArrayList<File> attachments) throws AttachmentException{
		if(attachments == null) throw new AttachmentException("attachments cant be null");
		this.attachments = attachments;
	}
	
	public EmailMessage(String sender, String content, MessageCategory category, String subject) {
		super(sender, content, category);
		setSubject(subject);
		setAttachments(new ArrayList<File>());
	}
	
	public EmailMessage(String sender, String content, Date sendDate, MessageCategory category, String subject, ArrayList<File> attachments) {
		super(sender, content, sendDate, category);
		setSubject(subject);
		setAttachments(attachments);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", subject:" + getSubject() + ", attachments: " + getAttachments();
	}

	@Override
	public String printCommunicationMethod() {
		return "Sent via Email Server";
	}

	@Override
	public String generatePreview() {
		return "[Email] Subject: " + getSubject() + " | From: " + getSender();
	}
	
	public void addAttachment(File file){
		getAttachments().add(file);
	}
	public void removeAttachment(File file) throws AttachmentException {
		if(!getAttachments().contains(file)) throw new AttachmentException("File not found in attachments");
		while(getAttachments().contains(file)) {
			getAttachments().remove(file);
		}
		System.out.println("deleted successfully");
	}
}
