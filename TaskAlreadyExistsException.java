/**
 * throws exception while trying to add a task which already exists according to description.
 */

public class TaskAlreadyExistsException extends RuntimeException {

    public TaskAlreadyExistsException(){ super();}
    public TaskAlreadyExistsException(String message){
        super(message);
    }
    public TaskAlreadyExistsException(String message,Throwable cause){ super(message,cause);}
}
