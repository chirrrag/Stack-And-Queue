import java.io.*;
import java.util.*;

public class LargestAreaHistogram {
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    // code
    Stack<Integer> st = new Stack<>();
    int[] nsr = new int[n];
    nsr[n - 1] = arr.length;
    st.push(n - 1);
    
    for(int i = nsr.length - 2; i >= 0; i--) {
        // pop for larger elemetns
        while(st.size() != 0 && arr[st.peek()] >= arr[i]) {
            st.pop();
        }
        // updaet answer
        if(st.size() == 0) {
            nsr[i] = arr.length;
        }
        else {
            nsr[i] = st.peek();
        }
        // push current idx into Stack
        st.push(i);
    }
    
    st = new Stack<>();
    
    int[] nsl = new int[n];
    nsl[0] = -1;
    st.push(0);
    
    for(int i = 1; i < nsl.length; i++) {
        // pop for larger elemetns
        while(st.size() != 0 && arr[st.peek()] >= arr[i]) {
            st.pop();
        }
        // updaet answer
        if(st.size() == 0) {
            nsl[i] = -1;
        }
        else {
            nsl[i] = st.peek();
        }
        // push current idx into Stack
        st.push(i);
    }
    
    // make ans
    int max= 0;
    for(int i = 0; i < arr.length; i++) {
        int height = arr[i];
        int width = nsr[i] - nsl[i] - 1;
        int ans = height * width;
        max = Math.max(max, ans);
    }
    System.out.println(max);
 }
}