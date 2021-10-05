package week7;
import java.util.*;
import java.io.*;
public class No15903 {
    public static void main(String[] args)  throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int cardSize = Integer.parseInt(st.nextToken());
        int plusCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>( (a,b) ->{
            return Long.compare(a,b);
        });
        for(int i = 0 ; i < cardSize ; i++){
            long card = Long.parseLong(st.nextToken());
            queue.add(card);
        }
        for(int i = 0 ; i < plusCount ; i++){
            long card1 = queue.poll();
            long card2 = queue.poll();
            long cardSum = card1 + card2;
            queue.add(cardSum);
            queue.add(cardSum);
        }
        long result = 0;
        for(Long i : queue){
            result+=i;
        }
        System.out.println(result);
    }
}
