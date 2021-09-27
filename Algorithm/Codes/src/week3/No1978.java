package week3;

import java.util.*;
import java.io.*;
public class No1978{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int result = 0;
        for(int i = 0 ; i < testCase ; i++){
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) continue;;
            int sqrt = (int)Math.sqrt(num);
            int j = 2;
            while(j<=sqrt && num%j!=0){
                j++;
            }
            if (j == sqrt+1)
                result++;
        }
        System.out.println(result);
    }
}