package personalstudy.구현;

import java.io.*;
import java.util.*;
public class No4673{
    static boolean[] arr = new boolean[10001];
    static StringBuilder sb = new StringBuilder();

    static int cal(int i){
        int result = 0;
        while(true){
            if(i/10==0) {
                result += i%10;
                break;
            }
            result += i%10;
            i /=10;
        }
        return result;
    }
    static void go(){
        for(int i = 1 ; i < 10001 ; i++){
            if(!arr[i]){
                sb.append(i).append("\n");
            }
            if(cal(i)+i<=10000){
                int next = i+cal(i);

                arr[next] = true;
            }
        }
    }

    public static void main(String[] args){
        go();
        System.out.println(sb);
    }
}