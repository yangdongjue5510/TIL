package week5;

import java.util.*;
import java.io.*;
public class No2217 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        Integer [] arr = new Integer[testCase];
        int max = 0;
        for(int i = 0 ; i < testCase ; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr,Collections.reverseOrder());
        for(int i = testCase-1 ; i >= 0 ; i--){
            max = Math.max((i+1)*arr[i], max);
        }
        System.out.println(max);
    }
}