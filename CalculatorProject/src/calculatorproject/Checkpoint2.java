/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorproject;
import java.util.*;
/**
 *
 * @author ashni
 */
public class Checkpoint2 {
    // this code does not repeat
    public static void main(String[] args) {
        System.out.println("Welcome to the IB Computer Science calculator!!");
        System.out.println();
        System.out.print("Enter an expression, or quit to exit: ");
        Scanner mathInput = new Scanner(mathExpression());
        mathTokens(mathInput);
    }
    
    public static String mathExpression() {
        Scanner userMath = new Scanner(System.in);
        return userMath.nextLine();
    }
    
    public static void mathTokens(Scanner mathInput) {
        boolean b = false;
        while(mathInput.hasNext() && mathInput.hasNextDouble() && b == false) {
            
            // first token is a number
            if(mathInput.hasNextDouble()) {
                double number = mathInput.nextDouble();
                if(!(mathInput.hasNext())) {
                    System.out.println(number);
                } else {
                
                // finding the operand
                    String operation = mathInput.next();
                    if(operation.equals("+")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(number);
                            System.out.println(operation);
                            double number2 = mathInput.nextDouble();
                            System.out.println(number2);
                        }
                    } else if(operation.equals("-")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(number);
                            System.out.println(operation);
                            double number2 = mathInput.nextDouble();
                            System.out.println(number2);
                        }
                    } else if(operation.equals("*")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(number);
                            System.out.println(operation);
                            double number2 = mathInput.nextDouble();
                            System.out.println(number2);
                        }
                    } else if(operation.equals("/")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(number);
                            System.out.println(operation);
                            double number2 = mathInput.nextDouble();
                            System.out.println(number2);
                        }
                    } else if(operation.equals("^")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(number);
                            System.out.println(operation);
                            double number2 = mathInput.nextDouble();
                            System.out.println(number2);
                        }
                    } else {
                        System.out.println("ERROR");
                    } 
                }
            }
        }
        
        boolean b2 = false;
        while(mathInput.hasNext() && !(mathInput.hasNextDouble()) && b2 == false) {
            
            // first token is not a number
            if(!(mathInput.hasNextDouble())) {
                String letters = mathInput.next();
                
                // if quit, then quit
                if(letters.equalsIgnoreCase("quit")) {
                    System.out.println(letters);
                    
                // otherwise, find the operand 
                } else {
                    if(letters.equals("|")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(letters);
                            double number = mathInput.nextDouble();
                            System.out.println(number);
                        } else {
                            System.out.println("ERROR");
                            b2 = true;
                        }
                    } else if(letters.equals("~")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(letters);
                            double number = mathInput.nextDouble();
                            System.out.println(number);
                        } else {
                            System.out.println("ERROR");
                            b2 = true;
                        }
                    } else if(letters.equalsIgnoreCase("c")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(letters);
                            double number = mathInput.nextDouble();
                            System.out.println(number);
                        } else {
                            System.out.println("ERROR");
                            b2 = true;
                        }
                    } else if(letters.equalsIgnoreCase("s")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(letters);
                            double number = mathInput.nextDouble();
                            System.out.println(number);
                        } else {
                            System.out.println("ERROR");
                            b2 = true;
                        }
                    } else if(letters.equalsIgnoreCase("t")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(letters);
                            double number = mathInput.nextDouble();
                            System.out.println(number);
                        } else {
                            System.out.println("ERROR");
                            b2 = true;
                        }
                    } else if(letters.equalsIgnoreCase("v")) {
                        if(mathInput.hasNextDouble()) {
                            System.out.println(letters);
                            double number = mathInput.nextDouble();
                            System.out.println(number);
                        } else {
                            System.out.println("ERROR");
                            b2 = true;
                        } 
                    } else {
                        System.out.println("ERROR");
                    } 
                }    
            }
        } 
    }   
}


