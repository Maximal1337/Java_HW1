# Java Messaging System - HW1

A comprehensive object-oriented messaging system built in Java that demonstrates inheritance, polymorphism, exception handling, and interface implementation through a unified message management platform.

## 📋 Project Overview

This project implements a messaging system that manages three types of messages: Email, Board Messages, and SMS. The system provides a console-based interface for creating, managing, searching, and organizing different message types with category-based classification and advanced filtering capabilities.

## ✨ Features

### Core Functionality
- **Multi-Type Message Management**: Support for Email, Board, and SMS messages
- **Interactive Console Menu**: User-friendly command-line interface
- **Message Operations**:
  - Add new messages (Email, Board, SMS)
  - Delete messages by index
  - View all messages with detailed information
  - Search messages by keywords
  - Filter digital messages (Email & SMS)
  - Generate message previews

### Message Types

#### 📧 Email Messages
- Subject line support
- File attachment management (add/remove attachments)
- Support for multiple file types (PDF, XLSX, etc.)
- Implements `IDigital` interface

#### 📌 Board Messages
- Priority levels: URGENT, REGULAR, UNIMPORTANT
- Board name assignment
- Timestamp tracking
- Preview generation (15-character limit)

#### 📱 SMS Messages
- Phone number validation
- Character count tracking
- Implements `IDigital` interface
- Mobile-specific formatting

### Message Categories
All messages support categorization:
- `WORK` - Professional communications
- `PERSONAL` - Personal messages
- `SPAM` - Unwanted messages
- `PROMOTIONS` - Marketing content
- `SOCIAL` - Social media notifications

## 🏗️ Architecture

### Class Hierarchy
```
Message (Abstract)
├── EmailMessage (implements IDigital)
├── BoardMessage
└── SMSMessage (implements IDigital)

Supporting Classes:
├── File
├── AttachmentException (Custom Exception)
├── IllegalCharAmount (Custom Exception)
└── IDigital (Interface)

Enums:
├── MessageCategory
└── PriorityType
```

### Key Components

#### Abstract Base Class: `Message`
- Common properties: sender, content, sendDate, category
- Abstract method: `generatePreview()`
- Keyword search functionality with regex parsing
- Input validation with exception handling

#### Interface: `IDigital`
- Method: `printCommunicationMethod()`
- Implemented by EmailMessage and SMSMessage
- Enables polymorphic filtering of digital communications

#### Custom Exceptions
- **AttachmentException**: Handles file attachment errors
- **IllegalCharAmount**: Validates character count constraints

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java IDE (Eclipse, IntelliJ IDEA, or VS Code)

### Installation

1. **Clone the repository**
```bash
   git clone https://github.com/Maximal1337/Java_HW1.git
   cd Java_HW1
```

2. **Compile the project**
```bash
   javac *.java
```

3. **Run the application**
```bash
   java Main
```

## 💻 Usage

### Menu Options
```
========== MENU ==========
1. Add message
2. Delete message
3. Print all messages
4. Search messages by keywords
5. Print digital messages only
6. Print message previews
0. Exit
```

### Example Usage

#### Adding an Email Message
1. Select option `1` from main menu
2. Choose message type `1` (Email)
3. Enter sender email address
4. Enter message content
5. Select category (WORK/PERSONAL/SPAM/PROMOTIONS/SOCIAL)
6. Enter email subject

#### Searching by Keywords
1. Select option `4` from main menu
2. Enter keywords separated by spaces
3. System displays all matching messages
4. Shows total count of found messages

#### Viewing Digital Messages Only
- Select option `5` to filter Email and SMS messages
- Displays communication method for each message
- Excludes Board messages from results

## 🎯 Object-Oriented Concepts Demonstrated

### 1. **Inheritance**
- Three-level hierarchy with `Message` as abstract base class
- Method overriding for `toString()` and `generatePreview()`
- Constructor chaining with `super()`

### 2. **Polymorphism**
- Abstract method implementation across subclasses
- Interface implementation (`IDigital`)
- Runtime polymorphism in message collection (`ArrayList<Message>`)

### 3. **Encapsulation**
- Private fields with public getters/setters
- Input validation in setter methods
- Protected data integrity

### 4. **Abstraction**
- Abstract `Message` class defines contract
- `IDigital` interface for communication methods
- Hidden implementation details

### 5. **Exception Handling**
- Custom exceptions: `AttachmentException`, `IllegalCharAmount`
- Try-catch blocks for robust error handling
- Validation with descriptive error messages

### 6. **Enumerations**
- Type-safe `MessageCategory` enum
- `PriorityType` enum for board messages

## 📁 File Structure
```
Java_HW1/
│
├── src/
│   ├── Message.java                 # Abstract base class
│   ├── EmailMessage.java            # Email implementation
│   ├── BoardMessage.java            # Board message implementation
│   ├── SMSMessage.java              # SMS implementation
│   ├── IDigital.java                # Digital communication interface
│   ├── File.java                    # File attachment model
│   ├── AttachmentException.java     # Custom exception
│   ├── IllegalCharAmount.java       # Custom exception
│   └── Main.java                    # Application entry point & UI
│
└── README.md                        # This file
```

## 🔍 Key Features Deep Dive

### Keyword Search Algorithm
- Removes punctuation using regex: `[,.!?;:\"'()\\[\\]{}\\-_/\\\\]`
- Case-insensitive matching
- Handles multiple spaces with `\\s+`
- Returns boolean for match status

### File Attachment Management
- Dynamic ArrayList for multiple attachments
- Add attachments to emails
- Remove specific attachments with validation
- Prevents null attachment lists

### Date Handling
- Uses `java.sql.Date` for timestamp management
- Automatic date assignment on message creation
- Custom date support for testing/backdating

## 🛠️ Technical Details

### Input Validation
- Non-null and non-empty string validation
- Category and priority enum validation
- Character count range validation
- Phone number format validation

### Error Handling Strategy
- Custom exceptions for domain-specific errors
- `IllegalArgumentException` for invalid inputs
- Runtime exceptions for critical failures
- User-friendly error messages

## 🔮 Future Enhancements

- [ ] Persistent storage (database integration)
- [ ] Message editing functionality
- [ ] Advanced search filters (by date, sender, category)
- [ ] Export messages to file (CSV, JSON)
- [ ] Email attachment size limits
- [ ] GUI implementation (JavaFX or Swing)
- [ ] Message threading/conversations
- [ ] Notification system
- [ ] User authentication
- [ ] Network-based message sending

## 📚 Learning Outcomes

This project demonstrates:
- ✅ Object-oriented design principles (SOLID)
- ✅ Java inheritance and polymorphism
- ✅ Interface design and implementation
- ✅ Exception handling best practices
- ✅ Collection framework usage (ArrayList)
- ✅ Enum types for type safety
- ✅ Input validation techniques
- ✅ Console I/O operations
- ✅ Method overriding and overloading
- ✅ Abstract classes vs interfaces
  
## 🤝 Contributing

This is an academic project. If you'd like to suggest improvements:
1. Fork the repository
2. Create a feature branch
3. Submit a pull request with detailed description

---

**Note**: This project was developed as part of a Java programming course to demonstrate understanding of object-oriented programming concepts and best practices.
