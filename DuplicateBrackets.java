import java.io.*;
import java.util.*;

public class DuplicateBrackets {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        
        System.out.println(duplicate(str));
    }
    
    public static boolean duplicate(String str) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == ')') {
                if(st.peek() == '(') {
                    return true;
                }
                else {
                    while(st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            }
            else {
                st.push(ch);
            }
        }
        
        // while(st.size() != 0) {
        //     if(st.peek() == '(' )
        //         return true;
        //     st.pop();
        // }
        return false;
    }

}