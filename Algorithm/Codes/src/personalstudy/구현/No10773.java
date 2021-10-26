package personalstudy.구현;
import java.io.*;
import java.util.*;
public class No10773 {
    static int plus(Stack<Integer> stk){
        int result = 0;
        for(Integer i : stk){
            result += i;
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stk = new Stack<>();

        for(int i = 0 ; i<N ; i++){
            int elem = Integer.parseInt(bf.readLine());
            if(elem == 0) {
                stk.pop();
                continue;
            }
            stk.push(elem);
        }

        System.out.println(plus(stk));
    }
}