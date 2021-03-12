// this will find next greater element on right with  O(n) complexity
import java.io.*;
import java.util.*;

public class NextGreaterElement{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
     
    //  O(n) complexity
   // solve
   int[] ngr = new int[arr.length];
   Stack<Integer> st = new Stack<>();
   
   ngr[ngr.length - 1] = -1;
   st.push(arr[ngr.length - 1]);
   
   for(int i = arr.length - 2; i >= 0; i--) {
       int ele = arr[i];
       if(ele >= st.peek()) {
           while(st.size() != 0 && ele >= st.peek() ) {
               st.pop();
           }
           if(st.size() == 0) {
               ngr[i] = -1;
               st.push(ele);
           }
           else {
               // st.size() != 0 && ele < st.peek()
               ngr[i] = st.peek();
               st.push(ele);
           }
       }
       else {
           // ele < st.peek()
           ngr[i] = st.peek();
           st.push(ele);
       }
       
   }
   
   return ngr;
 }

}