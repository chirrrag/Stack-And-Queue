import java.io.*;
import java.util.*;

public class InfixConversion{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    convert(exp);
    
 }
 
 public static void convert(String str) {
     Stack<String> operand = new Stack<>();
     Stack<Character> operator = new Stack<>();
     
     String prefix = "";
     String postfix = "";
     // prefix ==> operator + op1 + op2
     // postfix ==> op1 + op2 + operator
     
     // do for postfix
     for(int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if(ch >= 'a' && ch <= 'z') {
             operand.push(ch + "");
         }
         else if(ch == '(') {
             operator.push(ch);
         }
         else if(ch=='+' || ch=='-' || ch=='*' || ch=='/') {
             while(operator.size() != 0 && precedence(operator.peek()) >= precedence(ch)) {
                 String op2 = operand.pop();
                 String op1 = operand.pop();
                 char oprtr = operator.pop();
                 operand.push(op1 + op2 + oprtr +"");
             }
             operator.push(ch);
         }
         else if(ch == ')'){
             // solve till opening
             while(operator.peek() != '(') {
                 String op2 = operand.pop();
                 String op1 = operand.pop();
                 char oprtr = operator.pop();
                 operand.push(op1 + op2 + oprtr +"");
             }
             // 1 pop for opening bracket
             operator.pop();
         }
         else {
             // do nothing for spaces
             
         }
         
     }
     while(operator.size() != 0) {
         String op2 = operand.pop();
         String op1 = operand.pop();
         char oprtr = operator.pop();
         operand.push(op1 + op2 + oprtr +"");
     }
     postfix = operand.pop();
     
     // solve for prefix
     operand = new Stack<>();
     operator = new Stack<>();
     for(int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if(ch >= 'a' && ch <= 'z') {
             operand.push(ch + "");
         }
         else if(ch == '(') {
             operator.push(ch);
         }
         else if(ch=='+' || ch=='-' || ch=='*' || ch=='/') {
             while(operator.size() != 0 && precedence(operator.peek()) >= precedence(ch)) {
                 String op2 = operand.pop();
                 String op1 = operand.pop();
                 char oprtr = operator.pop();
                 operand.push(oprtr + op1 + op2);
             }
             operator.push(ch);
         }
         else if(ch == ')'){
             // solve till opening
             while(operator.peek() != '(') {
                 String op2 = operand.pop();
                 String op1 = operand.pop();
                 char oprtr = operator.pop();
                 operand.push(oprtr + op1 + op2);
             }
             // 1 pop for opening bracket
             operator.pop();
         }
         else {
             // do nothing for spaces
             
         }
         
     }
     while(operator.size() != 0) {
         String op2 = operand.pop();
         String op1 = operand.pop();
         char oprtr = operator.pop();
         operand.push(oprtr + op1 + op2);
     }
     prefix = operand.pop();
     System.out.println(postfix);
     System.out.println(prefix);
     
 }
 public static int precedence(char ch) {
     if(ch == '+' || ch == '-') return 1;
     else if(ch =='*' || ch == '/') return 2;
     else return 0; // returned 0 for braces
 }
}