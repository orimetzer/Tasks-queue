
import java.lang.reflect.Method;
import java.util.Iterator;


public class ArrayQueue <E extends Cloneable> implements Queue <E> {

    /**
     * Array of cloneable elements
     */
    private Cloneable [] qArray;
    /**
     *  maximum capacity of the given arrayQueue
     */
    private int maxCapacity;
    /**
     * index dynamically points to the rear element of the queue
     */
    private int rearElement;
    /**
     * index dynamically points to the front element of the queue
     */
    private int frontElement;


    /**
     *
     * @param maxCapacity maximum capacity to set.
     * @throws NegativeCapacityException() when trying to input negative number as a max capacity of the queue.
     */
    public ArrayQueue(int maxCapacity) {
        if (maxCapacity<0){
            throw new NegativeCapacityException();
        }
        this.maxCapacity = maxCapacity;
        rearElement = 0;
        frontElement = 0;
        qArray = new Cloneable[maxCapacity] ;

    }

    /**
     * returns the size of a queue considering the front element value, the rear element value and cycle number.
     * @return the size of the queue
     */
    @Override
    public int size(){
        if (maxCapacity==0){
            return 0;
        }
        if (rearElement==frontElement && qArray[frontElement] != null){
            return maxCapacity;
        }
        if(rearElement >=frontElement ) {
            return (rearElement-frontElement);}

        else {
            return (maxCapacity-frontElement+rearElement);
        }

    }

    /**
     * returns true if there are no elements in the queue, and false either.
     * @return true if there are no elements in the queue, and false either.
     */

    @Override
    public boolean isEmpty(){
        if (size() == 0){
            return true;
        }
        return false;
    }

    /**
     * add an element if the queue is not full.
     * Moreover , it initializes the rear element once we reached the end of the array and there are empty places.
     * @throws QueueOverflowException() while trying to add an element to a full queue.
     * @param element which we want to add
     */

    @Override
    public void enqueue(Cloneable element){
        if (size() == maxCapacity){
            throw new QueueOverflowException();
        }
        else if (rearElement < maxCapacity && qArray[rearElement]==null){
        qArray [rearElement] = element;
        rearElement = rearElement +1;
        }

        else if (rearElement == maxCapacity && frontElement != 0){
            rearElement = 0;
            qArray [rearElement] = element;
            rearElement = rearElement +1;
        }
    }

    /**
     * returns head element value and initializes the front element place in array.
     * @throws EmptyQueueException() when attempting  remove elements in the queue while it is empty.
     * @return head element value and initializes the front element place in array.
     */

    @Override
    public E dequeue() {
        Cloneable temp = null;
        if (size() == 0){
            throw new EmptyQueueException();
        }
        else if (frontElement < maxCapacity && frontElement <= rearElement) {
            temp = qArray[frontElement];
            qArray[frontElement] = null;
            frontElement = frontElement + 1;

        }
        else if (frontElement == maxCapacity && frontElement > rearElement){
            frontElement =0;
            temp = qArray[frontElement];
            qArray[frontElement] = null;
            frontElement = frontElement + 1;
        }
        return (E) temp;
    }

    /**
     * returns head element value.
     * @throws EmptyQueueException() when attempting to peek the queue while it is empty.
     * @return head element value.
     */

    @Override
    public E peek(){
        if (size() == 0){
            throw new EmptyQueueException();
        }
        else
            return (E) qArray [frontElement];
    }


    /**
     * returns deep copy of array queue using deep cloning method for generics, by using foreach loop.
     * @throws Exception while trying cloning an uncloneable object or trying to use invoke wrongly.
     * @return deep copy of array queue using deep cloning method for generics.
     */

    @Override
    public ArrayQueue<E> clone(){

        try {
            ArrayQueue copy = new ArrayQueue(maxCapacity);
            if (size() > 0){
                Method method = qArray[frontElement].getClass().getMethod("clone");
                for (Object obj:this){
                    Cloneable objectCopied = (Cloneable) method.invoke(obj);
                    copy.enqueue(objectCopied);
                }
            }
            return copy;

        } catch (Exception e) {
            return null;
        }

    }

    /**
     * returns new iterator element customized for ArrayQueue.
     * @return new iterator element customized for ArrayQueue.
     */

    @Override
    public Iterator <E> iterator() {
        return new ArrayQueueIterator<E> (qArray,frontElement,maxCapacity);
    }
}
