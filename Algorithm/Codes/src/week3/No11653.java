package week3;

import java.util.*;
import java.io.*;
public class No11653{
    public static final int MAX = 10000000;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[MAX+1];
        for(int i = 2 ; i <= MAX ; i++)
            isPrime[i] = true;
        for(int i = 2 ; i <= Math.sqrt(MAX); i++){
            if(!isPrime[i]) continue;
            for(int j = i*2 ; j <=MAX ; j+=i){
                isPrime[j] = false;
            }
        }
        int num = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while(num != 1){
            for(int i = 2 ; i <= MAX ; i++){
                if(isPrime[i] && num%i==0){
                    sb.append(i).append("\n");
                    num /=i;
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}