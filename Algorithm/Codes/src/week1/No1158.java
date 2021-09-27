package week1;
import java.util.*;
import java.io.*;
public class No1158{
    public static void main(String[] args) throws IOException{
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var arr = bf.readLine().split(" ");
        var sb = new StringBuilder();
        var N = Integer.parseInt(arr[0]);
        var K = Integer.parseInt(arr[1]);
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1 ; i <= N ; i++)
            queue.offer(i);
        sb.append("<");
        int count = 1;
        while(queue.size() != 0){
            if (count == K){
                int value = queue.poll();
                sb.append(value);
                if(queue.size() != 0)
                    sb.append(", ");
                count = 1;
                continue;
            }
            queue.offer(queue.poll());
            count++;
        }
        sb.append(">");
        System.out.print(sb);
    }
}