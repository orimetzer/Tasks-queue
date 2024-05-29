import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoList implements Cloneable , TaskIterable<Task>  {
    /**
     * array list of tasks
     */
    private ArrayList <Task> missions;
    /**
     * scan date for scanning the list
     */
    private Date scanDate;

    public ToDoList(){
        this.missions = new ArrayList<Task>();
    }

    /**
     * add a given task if it doesn't already exist in the list
     * @throws TaskAlreadyExistsException() while trying to add a task which already exists according to description.
     * @param task given task to add to the list
     */
    public void addTask(Task task){
        //first place
        if (missions.size()==0){
            missions.add(task);
        }

        else {

        for(int i=0;i< missions.size();i++){
            if (missions.get(i).getDescription().equals(task.getDescription())){
                throw new TaskAlreadyExistsException();
            }
        }
        missions.add(task);
        }
    }

    /**
     * returns current missions array.
     * @return current missions array.
     */

    public ArrayList <Task> getMissions (){
        return missions;
    }

    /**
     * returns a string represents the tasks array in the format asked
     * @return a string represents the tasks array in the format asked
     */

    @Override
    public String toString (){
        if (missions.size()>0){
            StringBuilder list = new StringBuilder("[(");
            for (int i=0;i< missions.size()-1;i++){
                list.append(missions.get(i).toString());
                list.append("), (");
            }
            list.append(missions.get(missions.size()-1)+")]");
            String strList = String.valueOf(list);
            return strList;
        }
        else{
            return "[]";
        }

    }


    /**
     * returns a unique hashcode for each ToDoList, based on it's attributes
     * @return A unique hashcode for each ToDoList, based on it's attributes
     */

    @Override
    public int hashCode (){
        int hashSummary = 0;
        for (int i=0;i<missions.size();i++){
            hashSummary = hashSummary + missions.get(i).hashCode();
        }
        return hashSummary;
    }

    /**
     * returns true only if the given array of tasks has the same tasks and hashcode
     * @param obj is given array to compare
     * @return true only if the given array has the same tasks and hashcode
     */

    @Override
    public boolean equals (Object obj){
        if(!(obj instanceof ToDoList)){
            return false;
        }
        ToDoList otherList = (ToDoList) obj;
        if (this.hashCode()==otherList.hashCode()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * returns deep copy of the task array by copying each task in a for loop
     * @return returns deep copy of the task array
     */

    @Override
    public ToDoList clone(){

        ToDoList copy = new ToDoList();
        for(int i=0;i<missions.size();i++){
            copy.missions.add(this.missions.get(i).clone());
        }
        return copy;

    }


    /**
     * sets the date which we want to scan the array due to it.
     * @param date is the given date we want to scan due to it.
     * @return the date we want to scan due to it, if it is not null.
     */

    @Override
    public Date setScanningDueDate (Date date){
        if (date==null){
            return scanDate = null;
        }
        else{
            return scanDate = date;
        }
    }


    /**
     * returns new iterator customized for ToDoList.
     * @return new iterator customized for ToDoList.
     */

    @Override
    public Iterator<Task> iterator() {
        return new ToDoListIterator (this,scanDate);
    }
}
