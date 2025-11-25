import java.sql.Date;


public class SMSMessage extends Message implements IDigital {

	private String phoneNumber;
	private int characterCount;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException{
		if(phoneNumber == null || phoneNumber.trim().isEmpty()) throw new IllegalArgumentException("phoneNumber cant be null or empty");
		this.phoneNumber = phoneNumber;
	}
	
	public int getCharacterCount() {
		return characterCount;
	}
	public void setCharacterCount(int characterCount) throws IllegalCharAmount{
		if(characterCount < 0) throw new IllegalCharAmount("Char ammount cant be negative");
		this.characterCount = characterCount;
	}
	
	public SMSMessage(String sender, String content, MessageCategory category, String phoneNumber, int characterCount) {
		super(sender, content, category);
		setPhoneNumber(phoneNumber);
		setCharacterCount(characterCount);
		
	}
	
	public SMSMessage(String sender, String content, Date sendDate, MessageCategory category, String phoneNumber, int characterCount) {
		super(sender, content, sendDate, category);
		setPhoneNumber(phoneNumber);
		setCharacterCount(characterCount);
	}
	
	public String generatePreview() {
		return "[SMS] From: " + getSender() + " | phoneNumber: " + getPhoneNumber() + " | subject: " + getContent();
	}
	
	public String printCommunicationMethod() {
		return "Sent via SMS";
	}
	
	public String toString() {
		return super.toString() + ", phoneNumber: " + getPhoneNumber() + ", characterCount: " + getCharacterCount();
	}
}
