import java.util.*;

public class ToDoListIterator implements Iterator<Task >  {


    /**
     * array of tasks
     */
    private ArrayList<Task> tasks;
    /**
     * the last task we want to scan in the array
     */
    private int lastPlace;
    /**
     * Represents the index of place in array which is dynamically moved.
     */
    private int current = -1;
    /**
     * sorted tasks according to given requirements
     */
    static ArrayList<Task> sortedTasks;

    /**
     * Constructor which initiate the array and the last requested place according to given date by user.
     * @param tdl the given ToDoList to iterate
     * @param scanDate date to initialize the last date according to it.
     */

    public ToDoListIterator(ToDoList tdl,Date scanDate){
        if (tdl.getMissions().size()==0){ //initialize lastPlace parameter in case of empty array.
            lastPlace = -1;
        }
        else{
            tasks = tdl.clone().getMissions();
            sortedTasks = whenComparing_sortByDates(tasks);
            if (scanDate == null){ //initialize lastPlace parameter in case of no scan date
                lastPlace = sortedTasks.size()-1;
            }


            else {
                for (int i=0;i<sortedTasks.size();i++){
                    if ((sortedTasks.get(i).getDueDate().equals(scanDate)) && (i == sortedTasks.size()-1)){
                        //initialize lastPlace parameter in case of full array which we need all of it including given date
                        lastPlace=i;
                        break;
                    }
                    else if (sortedTasks.get(i).getDueDate().after(scanDate) ){
                        //initialize lastPlace parameter in case of full array which we need part of it
                        lastPlace=i-1;
                        break;
                    }
                    else if ((sortedTasks.get(i).getDueDate().before(scanDate)) && (i == sortedTasks.size()-1)){
                        //initialize lastPlace parameter in case of full array which we need all of it until given date
                        lastPlace=i;
                        break;
                    }
                }
            }
        }


    }

    /**
     * Sorts given arrays according to date and alphabet (if needed)
     * @param notSortedTasks the given array to sort
     * @return sorted array by date and alphabet (if needed)
     */

    public ArrayList<Task> whenComparing_sortByDates(ArrayList<Task> notSortedTasks) {
        ArrayList<Task> sortedList;
        sortedList = notSortedTasks;
        Comparator <Task> datesComparator = Comparator.comparing(Task::getDueDate);
        Collections.sort(sortedList,datesComparator.thenComparing(Comparator.comparing(Task::getDescription)));
        return sortedList;
    }

    /**
     * checking if there is element in the next place of the array according to scan Date.
     * @return true if there is element in the next place of the array according to scan Date.
     */

    @Override
    public boolean hasNext(){
        if (current==lastPlace){
            return false;
        }
        else{
            return true;
        }
    }


    /**
     * return the next element in the array if there is, otherwise returns null.
     * @return the next element in the array if there is, otherwise returns null.
     */


    @Override
    public Task next(){
        if (!hasNext()){
            return null;
        }
        else{
            current++;
            return sortedTasks.get(current);
        }
    }



}
