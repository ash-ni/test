/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorproject;
import java.util.*;
// for testCalc()
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 *
 * @author ashni
 */
public class CalculatorProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
       /** Welcome to the calculator and letting user know the operations that
         * are valid to use
         * Operations are noted below with a comment*/
        System.out.println("Welcome to the IB Computer Science calculator!!");
        System.out.println();
        System.out.println("The math operations available in this calculator are:");
        System.out.println("Addition(+), Subtraction(-), Multiplication(*), Division(/), Modulus(%),");
        System.out.println("Exponentiation(^), Absolute value(|), Approximation(~), Cosine(c),");
        System.out.println("Sine(s), Tangent(t), Square root(v), Log with base 10(log),");
        System.out.println("Natural log(ln), Arccosine(arcc), Arcsine(arcs), Arctangent(arct),");
        System.out.println("Secant(sec), Cosecant(csc), and Cotangent(cot),");
        System.out.println();
        System.out.println("Note: The calculator is case sensitive for the mathematical operations!");
        System.out.println("Ex: CSC or Csc will result in an 'ERROR'. Please type 'csc'");
        System.out.println();
        // testCalc();
        startCalc();
    }
    
     
    /* public static void testCalc() throws FileNotFoundException{ 
        ArrayList<String> problems = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        // load problems from a file
        File fProblems = new File("problems.txt");
        Scanner sc = new Scanner(fProblems);        
        int count = 0;
        String line = "";
        int problemCount = 0;
        int resultCount = 0;
        while (sc.hasNextLine()){
            line = sc.nextLine();
            if (!line.startsWith("//") && !line.trim().equals("")){   // ignore comments at the beginning
                problems.add(line.substring(3).trim());
                problemCount++;
                if (sc.hasNextLine()){
                    line = sc.nextLine();
                    if (!line.startsWith("//") && !line.trim().equals("")){
                        results.add(line.substring(3).trim());
                        resultCount++;
                    }
                } 
                count++;
            }
        }
        if (problemCount == resultCount){
            // now run the tests
            for (int i=0; i<problemCount; i++){
                String prob = problems.get(i);
                String result = calculate(prob);
                if (result == null){
                    System.out.println("FAILED test " + i);
                    System.out.println("Expression: " + problems.get(i));
                    System.out.println("Expected result: " + results.get(i));
                    System.out.println("Actual: null String returned from calculate()");
                } else {
                    if (result.equals(results.get(i))){
                        System.out.println("PASSED test " + i);
                    } else {
                        System.out.println("FAILED test " + i);
                        System.out.println("Expression: " + problems.get(i));
                        System.out.println("Expected result: " + results.get(i));
                        System.out.println("Actual: " + result);
                    }
                }
                    
            }
        } else {
            System.out.println("problem file error");
        }    
            
    } */ 
    
    // ask for user math expression and calls calculate
    public static void startCalc() {
        System.out.print("Enter an expression, or quit to exit: "); 
        Scanner mathExpression = new Scanner(mathInput());
        calculate(mathExpression);
    }
    
    // puts user input (a String) into scanner
    public static String mathInput() {
        Scanner userMath = new Scanner(System.in);
        return userMath.nextLine();
    }   
    
    // checks if first token is operand or not and calls appropriate method
    public static void calculate(Scanner mathExpression) { 
        if(!(mathExpression.hasNext())) {
            System.out.println("ERROR");
            startCalc();
        } else {
            // starts with a operand
            if(mathExpression.hasNextDouble()) {
                System.out.print(threeOperation(mathExpression));
                System.out.println();
                startCalc();
            } 
            // does not start with operand
            else {
                // quit to exit
                String result = twoOperation(mathExpression);
                if (result.equalsIgnoreCase("quit")) {
                    endCalc();
                // starts with operator
                } else {
                    System.out.println(result);
                    startCalc();
                }
            }
        }
    }
    
    // checks for valid or invalid expressions and returns appropriate response    
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
                
            // modulus
            } else if(operation.equals("%")) {
                if(mathExpression.hasNextDouble()) {
                    double number2 = mathExpression.nextDouble();
                    double answer = number % number2;
                    finalanswer = number + " % " + number2 + " = " + answer;
                } else {
                    finalanswer = "ERROR";
                }
                
            // exponentiation
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
    
    // checks for valid or invalid expressions and returns appropriate response
    public static String twoOperation(Scanner mathExpression) {
        String finalanswer = "";
        String operator = mathExpression.next();
        // to quit the calculator
        if(operator.equalsIgnoreCase("quit")) {
            return "quit";
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
                
            // approximation
            } else if(operator.equals("~")) {
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
                
            // cosine in radians
            } else if(operator.equals("c")) {
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
                
            // sine in radians
            } else if(operator.equals("s")) {
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
                
            // tangent in radians
            } else if(operator.equals("t")) {
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
            } else if(operator.equals("v")) {
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
                
            // log with base 10
            } else if(operator.equals("log")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = Math.log10(number);
                        finalanswer = operator + " " + number + " = " + answer;
                    }
                } else {
                    finalanswer = "ERROR";
                }
                
            // natural log
            } else if(operator.equals("ln")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = Math.log1p(number - 1);
                        finalanswer = operator + " " + number + " = " + answer;
                    }  
                } else {
                    finalanswer = "ERROR";
                }
                
            // arccosine
            } else if(operator.equals("arcc")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(number >= -1 && number <= 1) {
                        if(mathExpression.hasNext()) {
                            finalanswer = "ERROR";
                        } else {
                            double answer = Math.acos(number);
                            finalanswer = operator + " " + number + " = " + answer;
                        }  
                    } else {
                        finalanswer = "ERROR";
                    }
                } else {
                    finalanswer = "ERROR";
                }
                
            // arcsine
            } else if(operator.equals("arcs")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(number >= -1 && number <= 1) {
                        if(mathExpression.hasNext()) {
                            finalanswer = "ERROR";
                        } else {
                            double answer = Math.asin(number);
                            finalanswer = operator + " " + number + " = " + answer;
                        }  
                    } else {
                        finalanswer = "ERROR";
                    }  
                } else {
                    finalanswer = "ERROR";
                }
                
            // arctangent
            } else if(operator.equals("arct")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(number >= -1 && number <= 1) {
                        if(mathExpression.hasNext()) {
                            finalanswer = "ERROR";
                        } else {
                            double answer = Math.atan(number);
                            finalanswer = operator + " " + number + " = " + answer;
                        }  
                    } else {
                        finalanswer = "ERROR";
                    }
                } else {
                    finalanswer = "ERROR";
                }
                
            // secant
            } else if(operator.equals("sec")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = 1 / (Math.cos(number));
                        finalanswer = operator + " " + number + " = " + answer;
                    }  
                } else {
                    finalanswer = "ERROR";
                }
                
            // cosecant
            } else if(operator.equals("csc")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = 1 / (Math.sin(number));
                        finalanswer = operator + " " + number + " = " + answer;
                    }  
                } else {
                    finalanswer = "ERROR";
                }
                
            // cotangent
            } else if(operator.equals("cot")) {
                if(mathExpression.hasNextDouble()) {
                    double number = mathExpression.nextDouble();
                    if(mathExpression.hasNext()) {
                        finalanswer = "ERROR";
                    } else {
                        double answer = 1 / (Math.tan(number));
                        finalanswer = operator + " " + number + " = " + answer;
                    }  
                } else {
                    finalanswer = "ERROR";
                }
            } else {
                finalanswer = "ERROR";
            }
        }
        return finalanswer;
    }
    
    // called if user input was "quit" to end calculator
    public static void endCalc() {
        System.out.println("quit");
        System.out.println();
        System.out.println("Thanks for stopping by!");
    }
}



