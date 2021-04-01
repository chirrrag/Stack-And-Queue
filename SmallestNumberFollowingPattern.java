import java.io.*;
import java.util.*;

public class SmallestNumberFollowingPattern{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // code
    
    smallestPattern(str);
 }
 
 public static void smallestPattern(String str) {
     
     int val = 1;
     String ans = "";
     Stack<Integer> st = new Stack<>();
     st.push(val);
     for(int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         
         if(ch == 'd') {
             val = val + 1;
             st.push(val);
         }
         else{
             while(st.size() != 0) {
                 int num = st.pop();
                 ans = ans + num + "";
             }
             val = val + 1;
             st.push(val);
         }
     }
     
     while(st.size() != 0) {
         ans = ans + st.pop();
     }
     System.out.println(ans);
 }
}