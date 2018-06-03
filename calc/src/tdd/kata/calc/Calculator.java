package tdd.kata.calc;

import java.util.StringTokenizer;

/**
 * TDD Kata Calculator class
 * @author Khalil Hassim
 */
public class Calculator {

    protected static int add(String numbers){
        //Check if the string is empty and return 0 if it is.
        if(numbers.trim().length() == 0){
            return 0;
        }
        //Set the number delimiter
        String delim = ",";
        StringTokenizer st = new StringTokenizer(numbers, delim);
        int total = 0;
        try{
            //Add all the numbers found by the tokenizer together
            while(st.hasMoreTokens()){
                total += Integer.parseInt(st.nextToken());
            }
        //Make sure the string is actually a number and return -1 if there are invalid charachters. 
        //I know invalid input checking isn't necessary, I just couldn't leave it out.
        }catch(NumberFormatException nfe){
            nfe.printStackTrace();
            return -1;
        }
        //Return added numbers
        return total;
    }
    
}
