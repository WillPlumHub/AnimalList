//C0490418
//William Plummer
//Comp 132, section 1B
//2019-02-12
/*This program creates references to the front and rear of the queue and
provides other programs with all the methods they might need to work with
QueueADT, such as; enqueue, which adds an object to the queue, dequeue, which
removes the first object from the queue, first, which returns the first
element from the queue for the user to check, isEmpty, which returns true if
the queue is empty, size, which counts the number of elements in the queue
and returns that number to the user, and toString which returns all the
elements of the queue in a string*/
package comp_139_lab_3;

import Exceptions.*;

/**
 * This program creates references to the front and rear of the queue and
 * provides other programs with methods to manipulate QueueADT
 *
 * @author willp
 * @param <T>
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private SinglyLinkedNode<T> front;
//create a reference to the front of the queue
    private SinglyLinkedNode<T> rear;
//create a reference to the rear of the queue

    public LinkedQueue() {
        front = null; //set front to null by default
        rear = null; //set rear to null by default
    }

    /**
     * Adds element sent by user to the rear of the queue and to the front of
     * the queue if queue is empty
     *
     * @param element
     */
    @Override
    public void enqueue(T element) {
        SinglyLinkedNode<T> node = new SinglyLinkedNode<T>(element);
        //create new node object
        node.setElement(element);
//set nodes element to the element provided by the user
        if (isEmpty()) { //if queue is empty
            front = node; //make front point to the new node
        } else { //if the queue isn't empty
            rear.setNext(node); //make rear point to the new node
        }
        rear = node; //rear points to the new node
    }

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of this queue
     * @throws EmptyQueueException if an empty collection exception occurs
     */
    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) { //if queue is empty
            throw new EmptyQueueException("Queue is empty");
//then throw the resulting EmptyQueueException up to parent class
        }
        T result = (T) front; //copy the front element
        front = front.getNext(); //set front to the next object in the queue
        return result; //and return the copy of front node
    }

    /**
     * Returns the element at the front of this queue.
     *
     * @return the element at the front of the queue
     * @throws EmptyQueueException
     */
    @Override
    public T first() throws EmptyQueueException {
        if (isEmpty()) { //if queue is empty
            throw new EmptyQueueException("Queue is empty");
            //then throw the resulting EmptyQueueException up to parent class
        }
        T obj = (T) front; //then copy the front element
        return obj; //and return the copy of the first element
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return front == null;
//return true if the front of the queue is equal to null
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the count integer which represents of the size of this queue
     */
    @Override
    public int size() {
        SinglyLinkedNode<T> temp = front;
//create reference to the front of the queue
        int count = 1; //create new int variable called count and set it to 1
        while (temp.getNext() != null) {
//while you aren't at the end of the queue
            temp = temp.getNext(); //move to the next spot in the queue
            count++; //add 1 to count
        }
        return count;
//return count, which represents the number of elements in the queue
    }

    /**
   * Returns a string representation of this queue.
   *
   * @return the string representation of this queue
   */
  @Override
  public String toString() {
    SinglyLinkedNode<T> temp = front;
//create reference to the front of the queue
    String s = ""; //create string to be filled
    if (isEmpty()) { //is queue is empty
      s = "Empty\n"; //fill string with message that queue is empty
      return s; //return that message to user
    } else { //if queue isn't empty
      //s = s + temp.getElement().toString() + "\n";
      while (temp != null) {
//while you aren't at the end of the queue
        s = s + temp.getElement().toString() + "\n";
//add all other elements to queue
        temp = temp.getNext();
//make temp reference point to next element in queue
      }
    }
    return s; //return string with all elements of queue copied onto it
  }
}
