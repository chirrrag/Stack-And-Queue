import java.io.*;
import java.util.*;

public class BalancedBrackets {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        
        System.out.println(balanced(str));
    }
    
    public static boolean balanced(String str) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch=='(' || ch == '{' || ch=='[') {
                st.push(ch);
            }
            else if(ch==')' || ch=='}' || ch==']') {
                if(st.size() == 0) {
                    // more closing brackets!!!!
                    return false;
                }
                else {
                    boolean counterPart = check(st, ch);
                    if(counterPart == true) {
                        st.pop();
                    }
                    else if(counterPart == false) {
                        // wrong counter part!!!
                        return false;
                    }
                }
            }
        }
        
        if(st.size() != 0) {
            // more opening brackets
            return false;
        }
        return true;
    }
    
    public static boolean check(Stack<Character> st, char symbol) {
        if(symbol == ')') {
            if(st.peek() == '(') return true;
        }
        else if(symbol == '}') {
            if(st.peek() == '{') return true;
        }
        else { // symbol == ']'
            if(st.peek() == '[') return true;
        }
        return false;
    }

}