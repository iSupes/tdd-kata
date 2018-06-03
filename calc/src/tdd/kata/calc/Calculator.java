package tdd.kata.calc;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * TDD Kata Calculator class
 * @author Khalil Hassim
 */
public class Calculator {

    protected static int add(String numbers) throws NumberFormatException{
        //Check if the string is empty and return 0 if it is.
        if(numbers.trim().length() == 0){
            return 0;
        }
        //Set the number delimiter
        String delim = ",";
        
        //Checks if a custom delimiter has been specified and uses it if it has
        //Added additional code to allow variable length delimiters
        if(numbers.length() > 3 && numbers.substring(0,2).equals("//")){
            int newLine = numbers.indexOf("\n");
            delim = numbers.substring(2,newLine);
            numbers = numbers.substring(newLine+1);            
        } else {
            //If no custom delimiter has been specified, continues to allow '\n' as well as ','
            //Replaces new line characters with delimiters to allow '\n' to be used as a delimiter.
            numbers = numbers.replace("\n", delim);
        }
        StringTokenizer st = new StringTokenizer(numbers, delim);
        int total = 0;
        String negatives = "";
        try{
            //Add all the numbers found by the tokenizer together
            while(st.hasMoreTokens()){
                String stNumber = st.nextToken();
                int number = Integer.parseInt(stNumber);
                //Checks if there were any negatives passed and stores them away if so
                if(number < 0){
                    negatives += stNumber +" ";
                }
                //Added check for numbers over 1000 to be ignored
                if(number <= 1000){
                    total += number;
                }
            }
        //Make sure the string is actually a number and return -1 if there are invalid characters. 
        //I know invalid input checking isn't necessary, I just couldn't leave it out.
        }catch(NumberFormatException nfe){
            nfe.printStackTrace();
            return -1;
        }
        //If any negatives were found, throws and exception including the negatives found
        if(negatives.length() > 0){
            throw new NumberFormatException("Negatives not allowed: "+negatives);
        }
        
        //Return added numbers
        return total;
    }
    
}
