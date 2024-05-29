import java.util.Date;

public interface TaskIterable<Task> extends Iterable<Task>{

    /**
     * declaration of method that has been overridden in ToDoList class.
     * @param date is the given date we want to scan due to it.
     * @return the date we want to scan due to it, if it is not null.
     */

    public Date setScanningDueDate (Date date);

}
