package week8;
import java.io.*;
import java.util.*;
public class No1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> list = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(bf.readLine());
            list.add(num);
        }

        long result = 0;
        if(N==1) result = 0;
        else{
            while(list.size()!=1){
                int a = list.poll();
                int b = list.poll();
                result += (a+b);
                list.add(a+b);
            }
        }
        System.out.println(result);
    }
}

