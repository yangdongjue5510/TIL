package week3;

import java.util.*;
import java.io.*;

public class No6588 {
    public static final int MAX = 1000000;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[MAX+1];
        for(int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        for(int i = 2; i <= MAX; i++) {
            for(int j = i * 2; j <= MAX; j += i) {
                if(isPrime[j]==false) continue;
                isPrime[j] = false;
            }
        }

        while(true) {
            int n = Integer.parseInt(bf.readLine());
            boolean ok = false;
            if(n == 0)
                break;
            for(int i = 2; i <= n/2; i++) {
                if(isPrime[i]==true && isPrime[n-i]==true) {
                    System.out.println(n + " = " + i + " + " + (n-i));
                    ok = true;
                    break;
                }
            }
            if(ok==false)
                System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}