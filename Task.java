import java.util.Date;

public class Task implements Cloneable{
    /**
     * The name of the given task
     */
    private String description;
    /**
     * The due date of the given task
     */
    private Date dueDate;

    /**
     *
     * @param description The name to give to the task
     * @param dueDate The due date to set for the task
     */
    public Task(String description, Date dueDate){
        this.description = description;
        this.dueDate = dueDate;
    }


    /**
     * Sets the due date of the task to the given date
     * @param newDueDate The due date to set for the task
     */
    public void setDueDate(Date newDueDate){
        dueDate = newDueDate;
    }

    /**
     *
     * @return Due date of the given task
     */
    public Date getDueDate(){
        return dueDate;
    }

    /**
     *
     * @return Description of the given task
     */
    public String getDescription (){
        return description;
    }

    /**
     * returns a string represents the name of the task and it's due date in the format asked
     * @return A string represents the name of the task and it's due date in the format asked
     */
    @Override
    public String toString (){
        if(dueDate.getMonth()<9 && dueDate.getDate()<10){
            return description+", 0"+dueDate.getDate()+".0"+(dueDate.getMonth()+1)+"."+(dueDate.getYear()+1900);
        }
        else if (dueDate.getMonth()<9){
            return description+", "+dueDate.getDate()+".0"+(dueDate.getMonth()+1)+"."+(dueDate.getYear()+1900);
        }
        else if(dueDate.getDate()<10){
            return description+", 0"+dueDate.getDate()+"."+(dueDate.getMonth()+1)+"."+(dueDate.getYear()+1900);
        }
        else{
            return description+", "+dueDate.getDate()+"."+(dueDate.getMonth()+1)+"."+(dueDate.getYear()+1900);
        }
    }

    /**
     * returns a unique hashcode for each task, based on it's attributes
     * @return A unique hashcode for each task, based on it's attributes
     */
    @Override
    public int hashCode (){
        int summary=0;
        for (int i=0;i<description.length();i++){ //creating distinction between strings with same chars but different order
            summary = summary+((description.charAt(i))*(i+1));
        }
    return (dueDate.getDate())*31+(dueDate.getMonth()+1)*12+(dueDate.getYear()+1900)+summary;
    }

    /**
     * returns true only if the given task has the same description, due date and hashcode
     * @param obj object given to compare to the task
     * @return true only if the given task has the same description, due date and hashcode
     */
    @Override
    public boolean equals (Object obj){
        if(!(obj instanceof Task)){
            return false;
        }
        Task otherTask = (Task) obj;
        if (this.dueDate.getDate()==otherTask.dueDate.getDate() && this.dueDate.getMonth()==otherTask.dueDate.getMonth() && this.dueDate.getYear()==otherTask.dueDate.getYear()){
            if(this.hashCode()==otherTask.hashCode()){
                return true;
            }
            else{return false;}
        }
        else{
            return false;
        }
    }

    /**
     * returns deep copy of the task
     * @throws CloneNotSupportedException if trying to clone an element which is not cloneable.
     * @return deep copy of the task
     */
    @Override
    public Task clone() {
        try {
            Task copy = (Task) super.clone();
            Date newDate = new Date(dueDate.getYear(), dueDate.getMonth(), dueDate.getDate());
            copy.dueDate = newDate;
            return copy;

        } catch (CloneNotSupportedException e) {
            return null;
        }

    }
}
