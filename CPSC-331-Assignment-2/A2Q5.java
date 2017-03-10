/**
 * Student ID: 10150607
 * Tutorial Section 2 
 * TA Maryam Soleimani
 *
 * A2Q5.java evaluates Lisp expressions using the algorithm devised in
 * question 1, used the BoundedStack interface as part of the implementations.
 * Syntax to run the program is:
 *      java A2Q5 type infile
 * where when type = 0, we use the array based bounded stack and when type = 1
 * we use the linked list based bounded stack, and infile is the file containing 
 * input with expressions to be evaluated. 
 * This program can handle both single digits and arbitrary integer values. 
 * 
 * @author Lamess Kharfan
 * @version 1.0
\ 
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;

public class A2Q5{
	
	
	//Global variable for the result evaluate produces	
	public static double endResult;

    /**
     * @param args the command line arguments
     * @param args[0] = type of BoundedStack to execute program with 
     * @param args[1] = file with input 
     */
    public static void main(String[] args) {
    	//Type determines if we are using an array or linked list 
        String type = args[0];
        
        try{
            //Set up all variables needed in reading from a file
            FileReader fileReader = new FileReader(args[1]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            String expression;
            
            //Read from file while we haven't reached an empty line
            while((line = bufferedReader.readLine()) != null)
            {
            	try{
                expression = line;
                int size = expression.length();
                //Create an array and linked list bounded stack of size expression.length
                BoundedStackArray stackArray = new BoundedStackArray(size);
                LinkedListBoundedStack stackLinked = new LinkedListBoundedStack(size);
                
                //If type == 0 then evaluate the expression using an array bounded stack
                if("0".equals(type))
                {
                    evaluate(expression, stackArray);
                    System.out.println(endResult);
                }
                //Otherwise, evaluate the expression using a linked list bounded stack
                else
                {
                    evaluate(expression, stackLinked);
                    System.out.println(endResult);
                    
                }
             }
             //Catch any exceptions thrown by the evaluate method
             catch(Exception e){
				System.out.println("Invalid Expression");			
			}
            }
            fileReader.close();
        }
        //Catch exceptions involved in reading from a file
        catch(IOException e)
        {
            System.out.println("IO Problem");
        }
        
    }

    /**
     * 
     * evaluate() evaluates the expression passed to it using the specified type
     * of of Bounded Stack.
     *
     * @param expression is the string of the Lisp expression to be evaluated
     * @param stackType is the type of stack used to evaluate Lisp expressions
     */
    public static double evaluate(String expression, BoundedStack stackType){

        //Index for outermost while loop
        int size = expression.length();
        
        int i = expression.length() - 1;
        
        //Variable for the result at the entire expression
        
        
        while(0 < size)
        { 
            //String to append popped characters to
            String base = "";
            //Push the value at the index to the stack
            stackType.push(expression.charAt(i));

            //Test if the character just pushed is a '('
            if((stackType.top()).equals('('))
            {
                try{
                    //Pop characters until we counter a ')'
                    while(!(stackType.top()).equals(')'))
                    {
                        Object pop = stackType.pop();
                        base = base + pop.toString();
                    }
                    //Pop the right most bracket and append to the string
                    Object popAgain = stackType.pop();
                    base = base + popAgain.toString();
                }
                //Catch exceptions including EmptyStackException
                catch(Exception e){
                    throw new IllegalArgumentException();
                                   
                }
                
                //Find out what operation to execute
                Character operator = base.charAt(1);

                //Call addition function if additon
                if(operator.equals('+'))
                {
                    try{
                        endResult = addition(base);

                        if((stackType.isEmpty() == false) && i == 0)
                        {
                        	throw new IllegalArgumentException();
                        }
                
                        stackType.push(endResult);
                    }
                    catch(Exception e)
                    {	
                    		throw new IllegalArgumentException();
                    }
                }
                //Call multiplication function if multiplication
                if(operator.equals('*'))
                {
                    try{
                        endResult = multiplication(base);
                        if((stackType.isEmpty() == false) && i == 0)
                        {
                        	throw new IllegalArgumentException();
                        }
                        stackType.push(endResult);
                    }
                    catch(Exception e){
                           throw new IllegalArgumentException();
                      
                    }
                }
                
                //Call the subtraction function if operation is subtraction
                if(operator.equals('-'))
                {
                    try{
                    endResult = subtraction(base); 
                     if((stackType.isEmpty() == false) && i == 0)
                        {
                        	throw new IllegalArgumentException();
                        }
                        stackType.push(endResult);
                    }
                    catch(Exception e)
                    {	
                    		throw new IllegalArgumentException();
                    }
                }
                
                //Call division function if operation is division
                if(operator.equals('/'))
                {
                    try{
                        endResult = division(base);
                        if(stackType.isEmpty() == false && i == 0)
                        {
                        	throw new IllegalArgumentException();
                        }
                        stackType.push(endResult);
                    }
                    catch(Exception e)
                    {
                    		throw new IllegalArgumentException();
                    }
                }    
            }                                
            
            //Decrement size and index 
            size = size - 1;
            i = i - 1;
        }
        //Return result of the expression back to the calling code.
        return endResult;
    }

   
    /**
     * additon() performs Lisp addition arithmetic on a string expression
     * passed to it.
     * @param stringExpression is the Lisp expression to evaluate 
     * @return result is the result of the addition
     * @throws NumberFormatException if the formatting of the expression is incorrect
     * @throws EmptyStackException is the arithmetic results in an empty stack
     */
    public static double addition(String stringExpression) 
    {
        double result = 0;
        String noLBrackets = stringExpression.replace("(", "");
        String noRBrackets = noLBrackets.replace(")", "");

        String [] parts = noRBrackets.split(" ");
        
        try{
            for(int i = 0; i < parts.length; i++)
            {
                if(parts[i].equals("+"))
                {
                    parts[i] = "0";
                    result = result + Double.parseDouble(parts[i]); 
                }
                else
                {
                    result = Double.parseDouble(parts[i]) + result;
                }
            }
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException();
        }
        catch(EmptyStackException e)
        {
             throw new EmptyStackException();
        }
        return result;
    }
    
    /**
     * subtraction() performs Lisp subtraction arithmetic on a string expression
     * @param stringExpression is the string Lisp expression to be evaluated 
     * @return result is the result of the Lisp expression evaluated
     * @throws NumberFormatException if the formatting of the expression is incorrect
     * @throws EmptyStackException is the arithmetic results in an empty stack
     */ 
    public static double subtraction(String stringExpression)
    {
        double result = 0;
        String noLBrackets = stringExpression.replace("(", "");
        String noRBrackets = noLBrackets.replace(")", "");

        String [] parts = noRBrackets.split(" ");
        try{
            if(parts.length == 1)
            		throw new NumberFormatException();
        
            if(parts.length == 2)
                result = -(Double.parseDouble(parts[1]));
        
            else{
                 for(int i = 0; i < parts.length; i++)
                {
                    if(parts[i].equals("-"))
                    {
                        parts[i] = "0";
                        result = result - Double.parseDouble(parts[i]); 
                    }
                    else
                    {
                        if(i == 1)
                            result = result + Double.parseDouble(parts[i]);
                        else    
                            result = result -(Double.parseDouble(parts[i]));
                    }
                }
            }
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException();
        }
        catch(EmptyStackException e)
        {
             throw new EmptyStackException();
        }
        
        return result;
    }
    /**
     * multiplication() performs Lisp multiplication arithmetic on a string expression
     * @param stringExpression is the Lisp multiplication expression to be evaluated 
     * @return result, the result of the multiplication expression evaluated 
     * @throws NumberFormatException if the formatting of the expression is incorrect
     * @throws EmptyStackException is the arithmetic results in an empty stack
     */
    public static double multiplication(String stringExpression)
    {
        double result = 0;
        String noLBrackets = stringExpression.replace("(", "");
        String noRBrackets = noLBrackets.replace(")", "");
        
        String [] parts = noRBrackets.split(" ");
     
        try{
            for(int i = 0; i < parts.length; i++)
            {
                if(parts[i].equals("*"))
                {
                    parts[i] = "1";
                    result = result + Double.parseDouble(parts[i]); 
                }   
                else
                {
                    result = Double.parseDouble(parts[i]) * result;
                }
            }
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException();
        }
        catch(EmptyStackException e)
        {
        	
             throw new EmptyStackException();
        }
        return result;
    }
    /**
     * division() performs Lisp division arithmetic on a string expression
     * @param stringExpression is the division String Lisp Expression to be evaluated 
     * @return result , the result of the division Lisp expression evaluated. 
     * @throws NumberFormatException if the formatting of the expression is incorrect
     * @throws EmptyStackException is the arithmetic results in an empty stack
     */
    public static double division(String stringExpression)
    {
        double result = 0;
        String noLBrackets = stringExpression.replace("(", "");
        String noRBrackets = noLBrackets.replace(")", "");

        String [] parts = noRBrackets.split(" ");
     
        try{
        		if(parts.length == 1)
        			throw new IllegalArgumentException();    
            if(parts.length == 2)
            {
                result = 1/(Double.parseDouble(parts[1]));
            }
            else
            {
                for(int i = 0; i < parts.length; i++)
                {
                    if(parts[i].equals("/"))
                    {
                        result = result + 0; 
                    }
                    else
                    {
                        if(i == 1)
                            result = result + Double.parseDouble(parts[i]);
                        else{
                            result = result / Double.parseDouble(parts[i]);
                        }
                    }
                }  
            }
           
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException();
        }
        catch(EmptyStackException e)
        {
             throw new EmptyStackException();
        }
            
        return result;   
    }
}

                          