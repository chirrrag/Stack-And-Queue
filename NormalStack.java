import java.io.*;
import java.util.*;

public class NormalStack {

  public static class CustomStack {
    int[] data;
    int tos;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      // write ur code here
      return (this.tos + 1);
    }

    void display() {
      // write ur code here
      for(int i = this.tos; i >= 0; i--) {
          System.out.print(this.data[i] + " ");
      }
      System.out.println();
    }

    void push(int val) {
      // write ur code here
      if(tos == data.length - 1) {
          System.out.println("Stack overflow");
          return ;
      }
      this.tos += 1;
      this.data[tos] = val;
    }

    int pop() {
      // write ur code here
      if(this.tos == -1) {
          System.out.println("Stack underflow");
          return -1;
      }
      int ans = this.data[this.tos];
      tos--;
      return ans;
    }

    int top() {
       // write ur code here
       if(this.tos == -1) {
          System.out.println("Stack underflow");
          return -1;
      }
      return this.data[this.tos];
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("display")){
        st.display();
      }
      str = br.readLine();
    }
  }
}