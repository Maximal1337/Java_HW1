import java.sql.Date;

enum PriorityType {UNIMPORTANT, REGULAR, URGENT}

public class BoardMessage extends Message {
	private PriorityType priority;
	private String boardName;
	
	public PriorityType getPriorityType() {
		return priority;
	}
	
	public void setPriorityType(PriorityType priority) {
		this.priority = priority;
	}
	
	public String getBoardName() {
		return boardName;
	}
	
	public void setBoardName(String boardName) throws IllegalArgumentException {
		if(boardName == null || boardName.trim().isEmpty()) throw new IllegalArgumentException("boardName cant be null or empty");
		this.boardName = boardName;
	}
	
	public BoardMessage(String sender, String content,  MessageCategory category, String boardName) {
		super(sender, content, category);
		setBoardName(boardName);
		setPriorityType(PriorityType.REGULAR);
	}
	
	public BoardMessage(String sender, String content, Date sendDate, MessageCategory category, PriorityType priority, String boardName) {
		super(sender, content, sendDate, category);
		setPriorityType(priority);
		setBoardName(boardName);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", priority: " + getPriorityType() + ", boardName: " + getBoardName();
	}

	@Override
	public String generatePreview() {
		if(getContent().length() < 15) {
			return "[Board] " + getSender() + ": " + getContent();
		}
		return "[Board] " + getSender() + ": " + getContent().substring(0, 15) + "...";
	}
}
