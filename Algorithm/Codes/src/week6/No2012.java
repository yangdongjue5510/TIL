package week6;
import java.util.*;
import java.io.*;
public class No2012 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        long complainSum = 0;
        for(int i = 0 ; i < N ; i++){
            long complain = (arr[i]-i-1 > 0) ? arr[i]-i-1 : i+1-arr[i];
            complainSum += complain;
        }
        System.out.println(complainSum);
    }
}