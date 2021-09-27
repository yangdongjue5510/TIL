package week1;
import java.util.*;
import java.io.*;
public class No10866{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < testCase ; i++){
            StringTokenizer st =new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();
            switch(cmd) {
                case "push_front" :
                    int frontValue = Integer.parseInt(st.nextToken());
                    queue.addFirst(frontValue);
                    break;
                case "push_back" :
                    int backValue = Integer.parseInt(st.nextToken());
                    queue.addLast(backValue);
                    break;
                case "pop_front" :
                    if(queue.isEmpty())
                        System.out.println(-1);
                    else{
                        System.out.println(queue.get(0));
                        queue.removeFirst();
                    }
                    break;
                case "pop_back" :
                    if(queue.isEmpty())
                        System.out.println(-1);
                    else{
                        System.out.println(queue.get(queue.size()-1));
                        queue.removeLast();
                    }
                    break;
                case "size" :
                    System.out.println(queue.size());
                    break;
                case "empty" :
                    int a = queue.isEmpty() ? 1 : 0;
                    System.out.println(a);
                    break;
                case "front" :
                    int front = queue.isEmpty() ? -1 : queue.get(0);
                    System.out.println(front);
                    break;
                case "back" :
                    int back = queue.isEmpty() ? -1 : queue.get(queue.size()-1);
                    System.out.println(back);
                    break;
            }
        }
    }
}