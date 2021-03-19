import java.io.*;
import java.util.*;

public class CelebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while(st.size() != 1) {
            int i = st.pop();
            int j = st.pop();
            if(arr[i][j] == 1) {
                // i knows j
                st.push(j);
            }
            else {
                // i don't know j
                st.push(i);
            }
        }
        
        int ans = st.pop();
        boolean flag = true;
        for(int i = 0; i < arr.length; i++) {
            if(i == ans) {
                continue;
            }
            if(arr[i][ans] == 0 || arr[ans][i] == 1) {
                flag = false;
            }
        }
        if(flag == false) {
            System.out.println("none");
            return;
        }
        else{
            System.out.println(ans);
        }
    }

}