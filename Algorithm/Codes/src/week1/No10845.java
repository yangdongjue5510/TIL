package week1;
import java.io.*;
import java.util.*;
public class No10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < testCase ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String cmd = st.nextToken();
            switch(cmd){
                case "push" :
                    int inputNum = Integer.parseInt(st.nextToken());
                    queue.add(inputNum);
                    break;
                case "pop" :
                    if (queue.size() != 0){
                        System.out.println(queue.get(0));
                        queue.removeFirst();
                    }
                    else
                        System.out.println(-1);
                    break;
                case "size" :
                    System.out.println(queue.size());
                    break;
                case "empty" :
                    if (queue.size() == 0)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front" :
                    if (queue.size() == 0)
                        System.out.println(-1);
                    else
                        System.out.println(queue.get(0));
                    break;
                case "back" :
                    if (queue.size() == 0)
                        System.out.println(-1);
                    else
                        System.out.println(queue.get(queue.size()-1));
                    break;
            }
        }
    }
}