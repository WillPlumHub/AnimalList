//C0490418
//William Plummer
//Comp 132, section 1B
//2019-11-
/*The program sends an error message to the user in response to a thrown
exception where the user inputs a name of two characters or less*/
package Exceptions;
/**
 * InvalidNameException.Java
 * This program is has any runtime errors thrown to it and responds by
 * outputting a message to the user.
 * @author willp
 */
public class InvalidNameException extends Exception{
    /**
     * Gets a message to display to the user if they inputs a name of
     * two characters or less.
     * @param msg
     */
    public InvalidNameException (String msg){
    super(msg);
    }
}
