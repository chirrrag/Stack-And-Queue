import java.io.*;
import java.util.*;

public class QueueToStack1 {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      // write your code here
      return mainQ.size();
    }

    void push(int val) {
      // write your code here
      // empty main quueue and push into helper
      while(mainQ.size() != 0) {
          int element = mainQ.remove();
          helperQ.add(element);
      }
    //   add current element into mainQ
      mainQ = new ArrayDeque<>();
      mainQ.add(val);
      // empty dhelper into main
      while(helperQ.size() != 0) {
          int ele = helperQ.remove();
          mainQ.add(ele);
      }
      helperQ = new ArrayDeque<>();
   }

    int pop() {
      // write your code here
      if(mainQ.size() == 0) {
          System.out.println("Stack underflow");
          return -1;
      }
      return mainQ.remove();
    }

    int top() {
      // write your code here
      if(mainQ.size() == 0) {
          System.out.println("Stack underflow");
          return -1;
      }
      return mainQ.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}