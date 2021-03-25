import java.io.*;
import java.util.*;

public class StackToQueue1 {

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      // write your code here
      return mainS.size();
    }

    void add(int val) {
      // write your code here
      // pop all elements from main and push into helper
      while(mainS.size() != 0) {
          int ele = mainS.pop();
          helperS.push(ele);
      }
      // push current val
      mainS.push(val);
      // pop all element from helper and push into main
      while(helperS.size() != 0) {
          int ele = helperS.pop();
          mainS.push(ele);
      }
    }

    int remove() {
      // write your code here
      if(mainS.size() == 0) {
          System.out.println("Queue underflow");
          return -1;
      }
      return mainS.pop();
    }

    int peek() {
      // write your code here
      if(mainS.size() == 0) {
          System.out.println("Queue underflow");
          return -1;
      }
      return mainS.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StackToQueueAdapter qu = new StackToQueueAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}