/**
 * throws exception when attempting  remove elements or peek the queue while it is empty.
 */

public class EmptyQueueException extends QueueException {

    public EmptyQueueException(){ super();}
    public EmptyQueueException(String message) {
        super(message);
    }
    public EmptyQueueException(String message,Throwable cause){ super(message,cause);}
}