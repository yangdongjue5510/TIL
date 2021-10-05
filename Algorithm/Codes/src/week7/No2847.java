package week7;

import java.io.*;
import java.util.*;
public class No2847 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < N ; i++){
            stack.push(Integer.parseInt(bf.readLine()));
        }
        int max = stack.pop();
        int result = 0;
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            if(max<= tmp){
                 result += (tmp - max + 1);
                 max = max - 1 ;
            }
            else{
                max = tmp;
            }
        }
        System.out.println(result);
    }
}
