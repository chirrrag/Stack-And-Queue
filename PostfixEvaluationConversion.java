import java.io.*;
import java.util.*;

public class PostfixEvaluationConversion{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    evaluation(exp);
    
 }
 public static void evaluation(String str) {
     Stack<Integer> operand = new Stack<>();
     Stack<String> infix = new Stack<>();
     Stack<String> prefix = new Stack<>();
     
     for(int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if(ch >= '0' && ch <= '9') {
             operand.push(ch - '0');
             infix.push(ch + "");
             prefix.push(ch + "");
         }
         else if(ch=='+' || ch=='-' || ch=='*' || ch=='/') {
             int op2 = operand.pop();
             int op1 = operand.pop();
             int ans = solve(op1, op2, ch);
             operand.push(ans);
             
             String o2 = infix.pop();
             String o1 = infix.pop();
             String infixAns = "(" + o1 + ch + o2 + ")";
             infix.push(infixAns);
             
             // prefix
             String p2 = prefix.pop();
             String p1 = prefix.pop();
             String prefixAns = ch + p1 + p2;
             prefix.push(prefixAns);
         }
         else {
             // do nothing for braces
         }
     }
     System.out.println(operand.pop());
     System.out.println(infix.pop());
     System.out.println(prefix.pop());
     
 }
 
 public static int solve(int op1, int op2, char ch) {
     if(ch == '+') return op1 + op2;
     else if(ch == '-') return op1 - op2;
     else if(ch == '*') return op1 * op2;
     else return op1 / op2;
 }
}