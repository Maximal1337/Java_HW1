
public class AttachmentException extends RuntimeException {
    public AttachmentException() {
        super("AttachmentException error");
    }
    
    public AttachmentException(String message) {
        super(message);
    }
}