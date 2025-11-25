public class IllegalCharAmount extends RuntimeException {
    public IllegalCharAmount() {
        super("Character count cannot be negative");
    }
    
    public IllegalCharAmount(String message) {
        super(message);
    }
}