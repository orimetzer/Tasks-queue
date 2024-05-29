/**
 * general runtime exception class assigned for exceptions regarding queue.
 */

public class QueueException extends RuntimeException{

    public QueueException(){}
    public QueueException(String message){
        super(message);
    }
    public QueueException(String message, Throwable cause){
        super(message,cause);
    }

}
