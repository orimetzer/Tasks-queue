/**
 * throws exception while trying to add an element to a full queue.
 */

public class QueueOverflowException extends QueueException {

    public QueueOverflowException(){super();}
    public QueueOverflowException(String message) {
        super(message);
    }
    public QueueOverflowException(String message,Throwable cause){ super(message,cause);}
}