package week7;
import java.io.*;
import java.util.*;
public class No1439 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        char[] arr = str.toCharArray();
        int zero = 0;
        int one = 0;
        if(arr[0]=='0') zero++;
        else one++;
        for(int i = 1; i<arr.length ; i++){
            if(arr[i-1]!=arr[i]){
                if(arr[i] == '0') zero++;
                else one++;
            }
        }
        System.out.println(Math.min(zero, one));
    }
}
