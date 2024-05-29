import java.util.Iterator;

public class ArrayQueueIterator <E> implements Iterator <E> {
    /**
     * Array of cloneable elements
     */
    private Cloneable[] values;
    /**
     * Represents the index dynamically move with foreach iteration.
     */
    private int current;
    /**
     *  maximum capacity of the given arrayQueue
     */
    private int maxCapacity;
    /**
     * Counts iterations.
     */
    private int count;

    /**
     *
     * @param values is arrays of tasks.
     * @param frontElement is front element place.
     * @param maxCapacity is max capacity value.
     */
    public ArrayQueueIterator(Cloneable[] values, int frontElement, int maxCapacity){
        this.values = values;
        current =  frontElement-1;
        this.maxCapacity = maxCapacity;
        count = 0;
    }

    /**
     * checking if there is element in the next place of the queue.
     * @return true if there is element in the next place of the queue, return false either.
     */

    @Override
    public boolean hasNext() {
        if (count==maxCapacity || maxCapacity==0){
            return false;
        }

        if (current<maxCapacity-1 && values[current+1] != null){
            return true;
        }
        else if (current == maxCapacity-1 && values[0] != null ){
            return true;
        }
        else { return false; }
    }

    /**
     * return the next element in the arrayQueue if there is, otherwise returns null.
     * @return the next element in the arrayQueue if there is, otherwise returns null.
     */

    @Override
    public E next() {
        if (!hasNext()){
            return null;
        }
        if (current==maxCapacity-1){
            current = 0;
            count++;
        }
        else if (current<maxCapacity-1 ){
            current+=1;
            count++;
        }

        return (E)values[current];

    }

}
