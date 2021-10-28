package personalstudy.구현;
import java.io.*;
import java.util.*;

public class No2504 {
    static int result;
    static char[] arr;
    static Stack<Character> stk = new Stack<>();

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = bf.readLine().toCharArray();
    }

    static void go(){
        int count = 1;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == '(' || arr[i] == '[') {
                stk.push(arr[i]);
                int a = (arr[i]=='(') ? 2 : 3;
                count *= a;
            }
            else if(arr[i] == ')'){
                if(stk.isEmpty() || stk.peek()!='('){
                    result = 0;
                    return;
                }
                if(arr[i-1] == '('){
                    result+= count;
                }
                stk.pop();
                count /= 2;
            }
            else if(arr[i] == ']'){
                if(stk.isEmpty() || stk.peek() != '['){
                    result = 0;
                    return;
                }
                if(arr[i-1] == '['){
                    result += count;
                }
                stk.pop();
                count /= 3;
            }
        }
        if(!stk.isEmpty()) result = 0;
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
        System.out.println(result);
    }
}
