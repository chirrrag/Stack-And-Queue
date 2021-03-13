// with the help of STACK
import java.io.*;
import java.util.*;

public class SlidingWindowMax{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code
    // find next greater element on right(INDEX)
    int[] ngr = new int[n];
    Stack<Integer> st = new Stack<>();
    st.push(n - 1);
    ngr[n - 1] = n;
    
    for(int i = ngr.length - 2; i >= 0; i--) {
        // pop for all smaller elements
        while(st.size() != 0 && arr[st.peek()] <= arr[i])
        {
            st.pop();
        }
        // update ngr[i]
        if(st.size() == 0) {
            ngr[i] = ngr.length;
        }
        else {
            ngr[i] = st.peek();
        }
        // push current index into Stack
        st.push(i);
    }
    
    // making anaswer array pf size (n - k + 1)
    int[] ans = new int[arr.length - k + 1];
    int j = 0;
    // loop will traverese from 0 to (n-k)
    for(int i = 0; i <= arr.length - k; i++) {
        if(j < i) {
            j = i;
        }
        while(ngr[j] <= (i + k - 1)){
            // when ngr[j] remains in range. update ngr[j]
            j = ngr[j];
        }
        ans[i] = arr[j];
    }
    
    for(int i = 0; i < ans.length; i++) {
        System.out.println(ans[i]);
    }
 }
}