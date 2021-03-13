import java.io.*;
import java.util.*;

public class InfixEval{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    System.out.println(infix(exp));
 }
 
 public static int infix(String str) {
     Stack<Integer> operand = new Stack<>();
     Stack<Character> operator = new Stack<>();
     
     for(int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if(ch >= '0' && ch <= '9') {
             // typecasting char to int
             int a = ch - '0';
             operand.push(a);
         }
         else if(ch=='+' || ch=='-' || ch=='*' || ch=='/') {
         
            while(operator.size() != 0 && precedence(operator.peek()) >= precedence(ch) ) {
                int op2 = operand.pop();
                int op1 = operand.pop();
                char oprtr = operator.pop();
                operand.push(calculate(op1, op2, oprtr));
            }
            operator.push(ch);
         }
         else if(ch == '(') {
             operator.push(ch);
         }
         else if(ch == ')') {
             while(operator.peek() != '(') {
                 int op2 = operand.pop();
                 int op1 = operand.pop();
                 char oprtr = operator.pop();
                 operand.push(calculate(op1, op2, oprtr));
             }
             operator.pop();
         }
         else {
             // do nothing, for empty spaces
         }
     }
     
     while(operator.size() > 0) {
         int op2 = operand.pop();
         int op1 = operand.pop();
         char oprtr = operator.pop();
         operand.push(calculate(op1, op2, oprtr));
     }
     return operand.pop();
 }
 
 public static int precedence(char ch) {
     if(ch == '+' || ch == '-') return 1;
     else if(ch == '*' || ch == '/') return 2;
     else return 0; // for opening brackets!!!!
 }
 
 public static int calculate(int op1, int op2, char ch) {
     if(ch == '+') return op1 + op2;
     else if(ch == '-') return op1 - op2;
     else if(ch == '*') return op1 * op2;
     else return (op1 / op2);
 }
}