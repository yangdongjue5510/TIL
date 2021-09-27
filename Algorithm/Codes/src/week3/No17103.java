package week3;

import java.util.*;
import java.io.*;
public class No17103{
    public static final int MAX = 1000000;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[MAX+1];
        for(int i = 2 ; i <= MAX ; i++)
            isPrime[i] = true;
        for(int i = 2 ; i <= Math.sqrt(MAX) ; i++){
            if(isPrime[i]==false) continue;
            for(int j = i*2 ; j <= MAX ; j+=i){
                isPrime[j] = false;
            }
        }
        while(testCase!=0){
            int num = Integer.parseInt(bf.readLine());
            int count = 0;
            for(int i = 2 ; i <= num/2 ; i++){
                if (isPrime[i] && isPrime[num-i]){
                    count++;
                }
            }
            sb.append(count).append("\n");
            testCase--;
        }
        System.out.print(sb);
    }
}