/*
* CSC115 Assignment 3
* V00837868
* 10/12/2K15
* Calc.java
* Calc accepts postfix expressions and outputs the results to the console.
* @author Devroop Banerjee.
*/

import java.util.*;

public class Calc{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter postfix expression: ");
        String in = scanner.nextLine();
        String[] split = in.split("\\s");

        Calc c = new Calc();

        try{
            c.evaluate(in, split);
        }catch(StackEmptyException e){
            System.out.println("Invalid expression");
        }catch(NumberFormatException e){
            System.out.println("Invalid expression");
        }
        
    }

    public static boolean isOperator(String in){
        return (in.equals("+") || in.equals("-") || in.equals("x") || in.equals("/"));
    }

    public void evaluate(String in, String[] split){
        isOperator(in);
        int numOne=0;
        int numTwo=0;
        int result = 0;
        Stack<Integer> stack = new LLStack<Integer>();

        for(int i = 0; i <= split.length-1; i++){
            String character = "";
            character = split[i];            

            if(!isOperator(character)){
                stack.push(new Integer(Integer.parseInt(character)));
                continue;
            }

            if (character.equals("+")){ 
               
               numTwo = (int)stack.pop();
               numOne = (int)stack.pop();
               result = numTwo + numOne;
               stack.push(new Integer(result));
               continue;
            }

            if (character.equals("x")){ 
               // stack.pop();
                numTwo = (int)stack.pop();
                numOne = (int)stack.pop();
                result = numTwo * numOne;
                stack.push(result);
                continue;
            }

            if (character.equals("-")){ 
                //stack.pop();
                numTwo = (int)stack.pop();
                numOne = (int)stack.pop();
                result = numOne - numTwo;
                stack.push(result);
                continue;
            }

            if (character.equals("/")){ 
                //stack.pop();
                numTwo = (int)stack.pop();
                numOne = (int)stack.pop();
                result = numOne / numTwo  ;
                stack.push(result);
                continue;
            }
        }
        System.out.println("Your result is: " + (int)stack.pop());
    }   
}
