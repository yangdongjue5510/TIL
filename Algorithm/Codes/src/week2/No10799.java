package week2;
import java.io.*;
import java.util.*;
public class No10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stk = new Stack<>();
        char[] arr = br.readLine().toCharArray();
        int result = 0;
        char prev = ' ';
        for(char c : arr){
            switch(c){
                case '(':
                    stk.push(c);
                    break;
                case ')':
                    stk.pop();
                    int add = prev == ')' ? 1 : stk.size();
                    result += add;
                    break;
            }
            prev = c;
        }
        System.out.println(result);
    }
}