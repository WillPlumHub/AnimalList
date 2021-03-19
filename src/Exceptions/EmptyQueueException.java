//C0490418
//William Plummer
//Comp 132, section 1B
//2019-11-
/*This program handles any EmptyQueueExceptions if they arise by sending an
error message, sent by another class, to the user*/
package Exceptions;

/**
 * This class represents an EmptyQueueException and sends an error message when
 * called
 *
 * @author C0490418
 */
public class EmptyQueueException extends Exception {

    /**
     * Sends a message, provided by another program, to the user
     *
     * @param msg
     */
    public EmptyQueueException(String msg) {
        super(msg); //send message from parent class
    }
}
