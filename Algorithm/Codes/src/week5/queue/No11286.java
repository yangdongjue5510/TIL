package week5.queue;
import java.io.*;
import java.util.*;
public class No11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1+o2 ==0) return o1-o2;
                o1 = (o1<0) ? -o1 : o1;
                o2 = (o2<0) ? -o2 : o2;
                return o1-o2;
            }
        });
        for(int i = 0 ; i < N ; i++){
            int x = Integer.parseInt(bf.readLine());
            if (x!=0){
                queue.add(x);
            }
            else{
                if (queue.size() != 0) x = queue.poll();
                System.out.println(x);
            }
        }
    }
}
