package week4;

import java.util.*;
import java.io.*;
public class No2138{
    static char[] arr1;
    static char[] arr2;
    static char[] target;
    public static void change(int index, char[] arr){
        arr[index-1] =(arr[index-1]=='0') ? '1':'0';
        arr[index] =(arr[index]=='0') ? '1':'0';
        if(index != arr.length-1){
            arr[index+1] =(arr[index+1]=='1') ? '0':'1';
        }
    }
    public static int test(char[] arr){
        int count = 0;
        for(int i = 0; i < arr.length-1 ; i++){
            if(arr[i]!=target[i]){
                change(i+1, arr);
                count ++;
            }
        }
        int result = (Arrays.equals(arr, target)) ? count : -1;
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr1 = bf.readLine().toCharArray();
        arr2 = arr1.clone();
        arr2[0] = (arr2[0]=='0') ? '1':'0';
        arr2[1] = (arr2[1]=='0') ? '1':'0';
        target = bf.readLine().toCharArray();
        int count1 = test(arr1);
        int count2 = test(arr2);
        int result = -1;
        if(count1 != -1 && count2 != -1){
            result = Math.min(count1, count2+1);
        }
        else if(count1 != -1) result = count1;
        else if(count2 != -1) result = count2+1;
        System.out.println(result);
    }
}
