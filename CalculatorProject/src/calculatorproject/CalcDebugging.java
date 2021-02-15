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
public class CalcDebugging {
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to the IB Computer Science calculator!!");
        System.out.println();
        startCalc();
    }
    
    public static void startCalc() {
        System.out.print("Enter an expression, or quit to exit: "); 
        Scanner mathExpression = new Scanner(mathInput());
        String s = mathInput();
        if(s.equalsIgnoreCase("quit")) {
            System.out.println("1");
            endCalc();
            System.out.println("2");
        } else {
            System.out.println("before calculate");
            calculate(mathExpression);
            System.out.println("after calculate");
        }
    }
    
    public static String mathInput() {
        Scanner userMath = new Scanner(System.in);
        return userMath.nextLine();
    }   
    
    public static void calculate(Scanner mathExpression) {   
        // starts with a operand
        if(mathExpression.hasNextDouble()) {
            System.out.print(threeOperation(mathExpression));
            System.out.println();
            startCalc();
        } else {
            System.out.println("Before twoOperation:");
            System.out.println(twoOperation(mathExpression));
            //String s = twoOperation(mathExpression);
            System.out.println("s1:" + twoOperation(mathExpression));
            //System.out.println("s = " + s);
            //System.out.print("answer:" + twoOperation(mathExpression));
            //if(twoOperation(mathExpression).equals("quit")) {
               // endCalc();
           // } else {
                System.out.println();
                startCalc();
            //}
        }
    }
        
    public static String threeOperation(Scanner mathExpression) {
        String finalanswer = "";
        double number = mathExpression.nextDouble();
        // input of a number without operand
        if (!(mathExpression.hasNext())) {
            finalanswer = "ERROR";
        } else {
            String operation = mathExpression.next();
            // addition
            if(operation.equals("+")) {
                if(mathExpression.hasNextDouble()) {
                    double number2 = mathExpression.nextDouble();
                    double answer = number + number2;
                    finalanswer = number + " + " + number2 + " = " + answer;
                } else {
                    finalanswer = "ERROR";
                }
            // subtraction
            } else if(operation.equals("-")) {
                if(mathExpression.hasNextDouble()) {
                    double number2 = mathExpression.nextDouble();
                    double answer = number - number2;
                    finalanswer = number + " - " + number2 + " = " + answer;
                } else {
                    finalanswer = "ERROR";
                }
            // multiplication
            } else if(operation.equals("*")) {
                if(mathExpression.hasNextDouble()) {
                    double number2 = mathExpression.nextDouble();
                    double answer = number * number2;
                    finalanswer = number + " * " + number2 + " = " + answer;
                } else {
                    finalanswer = "ERROR";
                }
            // division
            } else if(operation.equals("/")) {
                if(mathExpression.hasNextDouble()) {
                    double number2 = mathExpression.nextDouble();
                    double answer = number / number2;
                    finalanswer = number + " / " + number2 + " = " + answer;
                } else {
                    finalanswer = "ERROR";
                }
            // exponents
            } else if(operation.equals("^")) {
                if(mathExpression.hasNextDouble()) {
                    double number2 = mathExpression.nextDouble();
                    double answer = number;
                    for(int i = 1; i < number2; i++) {
                        answer = answer * number;
                    }
                    finalanswer = number + " ^ " + number2 + " = " + answer;
                } else {
                    finalanswer = "ERROR";
                }
            } else {
                finalanswer = "ERROR";
            }
        }
        return finalanswer;
    }
    
    public static String twoOperation(Scanner mathExpression) {
        String finalanswer = "";
        String operator = mathExpression.next();
        // quit calculator
        System.out.println("operator: " + operator);
        if(operator.equalsIgnoreCase("quit")) {
            System.out.println("quit if loop:");
            finalanswer = "quit";
        } else {
            // absolute value
            if(operator.equals("|")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = Math.abs(number);
                        finalanswer = operator + " " + number + " = " + answer;
                    }
                } else {
                    finalanswer = "ERROR";
                }
            // approxiamtion
            } else if (operator.equals("~")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = Math.round(number);
                        finalanswer = operator + " " + number + " = " + answer;
                    }                
                } else {
                    finalanswer = "ERROR";
                }
            // cosine
            } else if (operator.equals("c")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = Math.cos(number);
                        finalanswer = operator + " " + number + " = " + answer;
                    }                               
                } else {
                    finalanswer = "ERROR";
                }
            // sine
            } else if (operator.equals("s")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = Math.sin(number);
                        finalanswer = operator + " " + number + " = " + answer;
                    }                          
                } else {
                    finalanswer = "ERROR";
                }
            // tangent
            } else if (operator.equals("t")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = Math.tan(number);
                        finalanswer = operator + " " + number + " = " + answer;
                    }                          
                } else {
                    finalanswer = "ERROR";
                }
            // square root
            } else if (operator.equals("v")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = Math.sqrt(number);
                        finalanswer = operator + " " + number + " = " + answer;
                    }                              
                } else {
                    finalanswer = "ERROR";
                }               
            } else {
                finalanswer = "QUIT";
            }
        }
        System.out.println("return finalanswer:" + finalanswer);
        return finalanswer;
    }
    
    public static void endCalc() {
        System.out.println("Thanks for stopping by!");
    }
}

