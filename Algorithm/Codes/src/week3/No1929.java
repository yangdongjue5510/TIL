package week3;

import java.util.*;
import java.io.*;
public class No1929 {
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a==1) a=2;
        for (int i = a ; i <= b ; i++){
            int j = 2;
            int sqrt = (int)Math.sqrt(i);
            while(j<=sqrt && i%j!=0){
                j++;
            }
            if (j==sqrt+1) System.out.println(i);
        }
    }
}