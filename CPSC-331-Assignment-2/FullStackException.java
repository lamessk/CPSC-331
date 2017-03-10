/**
 * FullStackException class extends RuntimeException which gets thrown when the bounded 
 * stack becomes full.
 *
 * @author  Lamess Kharfan
 * @version 1.0
 * Student ID: 10150607
 * Tutorial Section 2 
 * TA Maryam Soleimani
 */
public class FullStackException extends RuntimeException {

	public FullStackException(){
		super("Full Stack Exception");
	}
	
	public FullStackException(String message){
		super(message);
	}

}
