package week2;
import java.util.*;
import java.io.*;
public class No17413 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bf.readLine(),">",true);
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            char[] arr = st.nextToken().toCharArray();
            int tmp = 0;
            outerLable:
            for (int i = 0; i<arr.length ; i++){
                char c = arr[i];
                switch(c){
                    case '<':
                        break outerLable;
                    case ' ':
                        while(stk.size()!=0)
                            sb.append(stk.pop());
                        sb.append(' ');
                        break;
                    default:
                        stk.push(c);
                        break;
                }
                tmp++;
            }
            while(stk.size()!=0)
                sb.append(stk.pop());
            for (int i = tmp; i<arr.length ; i++)
                sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}