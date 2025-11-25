import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Message> messages = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			initializeMessages();
			boolean running = true;
			while (running) {
				printMenu();
				int choice = getIntInput();
				switch (choice) {
					case 1:
						addMessage();
						break;
					case 2:
						deleteMessage();
						break;
					case 3:
						printAllMessages();
						break;
					case 4:
						searchByKeywords();
						break;
					case 5:
						printDigitalMessages();
						break;
					case 6:
						printMessagePreviews();
						break;
					case 0:
						running = false;
						System.out.println("Exiting program...");
						break;
					default:
						System.out.println("Invalid choice! Please try again.");
				}
			}
		} catch (Exception e) {
			System.err.println("Fatal error occurred: " + e.getMessage());
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	// Initialize test data
	private static void initializeMessages() {
		// 2 EmailMessage
		EmailMessage email1 = new EmailMessage(
			"alice@example.com",
			"Please review the attached project proposal for Q4.",
			MessageCategory.WORK,
			"Project Proposal Review"
		);

		email1.addAttachment(new File("proposal", "pdf"));
		email1.addAttachment(new File("budget", "xlsx"));
		
		EmailMessage email2 = new EmailMessage(
			"bob@example.com",
			"Happy birthday! Hope you have a great day!",
			new Date(System.currentTimeMillis() - 86400000), // yesterday
			MessageCategory.PERSONAL,
			"Happy Birthday!",
			new ArrayList<>()
		);
		
		// 2 BoardMessage
		BoardMessage board1 = new BoardMessage(
			"admin",
			"Server maintenance scheduled for tonight at 11 PM. Expected downtime: 2 hours.",
			Date.valueOf("2024-01-15"),
			MessageCategory.WORK,
			PriorityType.URGENT,
			"Cool Board"
		);
		
		BoardMessage board2 = new BoardMessage(
			"hr_department",
			"Reminder: Submit your timesheets by Friday end of day.",
			MessageCategory.WORK,
			"Nice board"
		);
		
		// 2 SMSMessage
		SMSMessage sms1 = new SMSMessage(
			"John",
			"Meeting at 3pm today in conference room B.",
			MessageCategory.WORK,
			"+972-50-1234567",
			44
		);
		
		SMSMessage sms2 = new SMSMessage(
			"Sarah",
			"Don't forget to buy milk on your way home!",
			new Date(System.currentTimeMillis() - 3600000), // 1 hour ago
			MessageCategory.PERSONAL,
			"+972-50-7654321",
			45
		);
		
		// Add to array
		messages.add(email1);
		messages.add(email2);
		messages.add(board1);
		messages.add(board2);
		messages.add(sms1);
		messages.add(sms2);
		
		System.out.println("Initialized " + messages.size() + " messages.");
	}

	// Menu
	private static void printMenu() {
		System.out.println("\n========== MENU ==========");
		System.out.println("1. Add message");
		System.out.println("2. Delete message");
		System.out.println("3. Print all messages");
		System.out.println("4. Search messages by keywords");
		System.out.println("5. Print digital messages only");
		System.out.println("6. Print message previews");
		System.out.println("0. Exit");
		System.out.print("Your choice: ");
	}

	// 1. Add message
	private static void addMessage() {
		System.out.println("\n--- Adding New Message ---");
		System.out.println("Select message type:");
		System.out.println("1. Email");
		System.out.println("2. Board Message");
		System.out.println("3. SMS");
		System.out.print("Your choice: ");

		int type = getIntInput();
		try {
			System.out.print("Sender: ");
			String sender = scanner.nextLine();
			
			System.out.print("Content: ");
			String content = scanner.nextLine();
			
			System.out.print("Category (WORK/PERSONAL/SPAM/PROMOTIONS/SOCIAL): ");
			String categoryStr = scanner.nextLine().toUpperCase();
			MessageCategory category = MessageCategory.valueOf(categoryStr);
			
			switch (type) {
				case 1:
					System.out.print("Subject: ");
					String subject = scanner.nextLine();
					EmailMessage email = new EmailMessage(sender, content, category, subject);
					messages.add(email);
					System.out.println("Email message added!");
					break;
					
				case 2:
					System.out.print("Priority (URGENT/REGULAR/UNIMPORTANT): ");
					String priorityStr = scanner.nextLine().toUpperCase();
					PriorityType priority = PriorityType.valueOf(priorityStr);
					Date sendDate =  new Date(System.currentTimeMillis());
					System.out.print("boardName: ");
					String boardName = scanner.nextLine().toUpperCase();
					BoardMessage board = new BoardMessage(sender, content, sendDate, category, priority, boardName);
					messages.add(board);
					System.out.println("Board message added!");
					break;
					
				case 3:
					System.out.print("Phone number: ");
					String phone = scanner.nextLine();
					
					SMSMessage sms = new SMSMessage(sender, content, category, phone, content.length());
					messages.add(sms);
					System.out.println("SMS message added!");
					break;
					
				default:
					System.out.println("Invalid message type!");
			}
		} catch (Exception e) {
			System.out.println("Error while adding: " + e.getMessage());
		}
	}

	// 2. Delete message
	private static void deleteMessage() {
		if (messages.isEmpty()) {
			System.out.println("No messages to delete!");
			return;
		}
		
		System.out.println("\n--- Delete Message ---");
		printAllMessagesWithIndex();
		
		System.out.print("Enter message number to delete: ");
		int index = getIntInput();
		
		if (index >= 0 && index < messages.size()) {
			Message removed = messages.remove(index);
			System.out.println("Message deleted: " + removed.generatePreview());
		} else {
			System.out.println("Invalid message number!");
		}
	}
	
	// Helper function for deletion
	private static void printAllMessagesWithIndex() {
		System.out.println("\n========== MESSAGE LIST ==========");
		for (int i = 0; i < messages.size(); i++) {
			System.out.println("[" + i + "] " + messages.get(i).generatePreview());
		}
	}

	// 3. Print all messages
	private static void printAllMessages() {
		if (messages.isEmpty()) {
			System.out.println("\nNo messages in the system.");
			return;
		}
		
		System.out.println("\n========== ALL MESSAGES (" + messages.size() + ") ==========");
		for (int i = 0; i < messages.size(); i++) {
			System.out.println("\n[" + i + "] " + messages.get(i).toString());
		}
	}

	// 4. Search by keywords
	private static void searchByKeywords() {
		System.out.println("\n--- Search by Keywords ---");
		System.out.print("Enter keywords separated by spaces: ");
		String input = scanner.nextLine();
		String[] keywordsArray = input.split(" ");
		
		ArrayList<String> keywords = new ArrayList<>();
		for (String keyword : keywordsArray) {
			if (!keyword.trim().isEmpty()) {
				keywords.add(keyword.trim());
			}
		}
		
		if (keywords.isEmpty()) {
			System.out.println("No keywords entered!");
			return;
		}
		
		int count = 0;
		System.out.println("\nFound messages:");
		for (Message msg : messages) {
			if (msg.find(keywords)) {
				count++;
				System.out.println(" - " + msg.generatePreview());
			}
		}
		
		System.out.println("\nTotal found: " + count + " messages");
	}

	// 5. Print only digital messages
	private static void printDigitalMessages() {
		System.out.println("\n========== DIGITAL MESSAGES ==========");
		int count = 0;
		
		for (Message msg : messages) {
			if (msg instanceof IDigital) {
				System.out.println("\n" + msg.toString());
				System.out.println("Communication method: " + ((IDigital) msg).printCommunicationMethod());
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("No digital messages.");
		} else {
			System.out.println("\nTotal digital messages: " + count);
		}
	}

	// 6. Additional option - print all message previews
	private static void printMessagePreviews() {
		if (messages.isEmpty()) {
			System.out.println("\nNo messages in the system.");
			return;
		}
		
		System.out.println("\n========== MESSAGE PREVIEWS ==========");
		for (int i = 0; i < messages.size(); i++) {
			System.out.println("[" + i + "] " + messages.get(i).generatePreview());
		}
	}

	// Helper function for integer input
	private static int getIntInput() {
		while (true) {
			try {
				String input = scanner.nextLine();
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.print("Please enter a number: ");
			}
		}
	}
}