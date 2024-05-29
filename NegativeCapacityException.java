/**
 * throws exception when trying to input negative number as a max capacity of the queue.
 */

public class NegativeCapacityException extends QueueException{

    public NegativeCapacityException(){ super();}
    public NegativeCapacityException(String message){
        super(message);
    }
    public NegativeCapacityException(String message,Throwable cause){ super(message,cause);}

}
