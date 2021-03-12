// O(n)
import java.io.*;
import java.util.*;

public class StockSpan{
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

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve
   int[] ngl = new int[arr.length];
   Stack<Integer> st = new Stack<>();
   st.push(0);
   ngl[0] = 1;
   
   for(int i = 1; i < arr.length; i++) {
       // pop all smaller elements
       while(st.size() != 0 && arr[st.peek()] <= arr[i]) {
           st.pop();
       }  
       
       // update answer
       if(st.size() == 0) {
           ngl[i] = i + 1;
       }
       else {
           ngl[i] = i - st.peek();
       }
       // push current index
       st.push(i);
   }
   return ngl;
 }

}