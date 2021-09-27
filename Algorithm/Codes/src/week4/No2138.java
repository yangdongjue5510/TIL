package week4;

import java.util.*;
import java.io.*;
public class No2138{
    static char[] arr1;
    static char[] arr2;
    static char[] arr3;
    public static int change(char[] a){
        int result = 0;
        for(int i = 1 ; i < a.length ; i++){
            if(arr2[i] != a[i]){
                if(i==a.length-1){
                    a[i-1]= (a[i-1]=='0')?'1':'0';
                    a[i]= (a[i]=='0')?'1':'0';
                }
                else{
                    a[i-1]= (a[i-1]=='0')?'1':'0';
                    a[i]= (a[i]=='0')?'1':'0';
                    a[i+1]= (a[i+1]=='0')?'1':'0';
                }
                result++;
            }
        }
        if(Arrays.equals(arr2, a))
            result = -1;
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr1 = bf.readLine().toCharArray();
        arr2 = bf.readLine().toCharArray();
        arr3 = arr1.clone();
        arr3[0] =  (arr3[0] == '0') ? '1':'0';
        arr3[1] =  (arr3[1] == '0') ? '1':'0';
        int result1 = change(arr1);
        int result2 = change(arr3);
        if (result1 != -1 && result2 != -1)
            System.out.println(Math.min(result1, result2));
        else if(result1 != -1)
            System.out.println(result1);
        else if(result2 != -1)
            System.out.println(result2);
        else
            System.out.println(-1);
    }
}
