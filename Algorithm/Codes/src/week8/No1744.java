package week8;
import java.util.*;
import java.io.*;
public class No1744 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        for(int i = 0; i<N ; i++){
            int n = Integer.parseInt(bf.readLine());
            if(n<=0) minus.add(n);
            else plus.add(n);
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);
        int result = 0;
        for(int i = 0; i < plus.size()-1 ; i+=2){
            int a = plus.get(i);
            int b = plus.get(i+1);
            if(a==1 || b==1) result+=(a+b);
            else result+=(a*b);
        }
        if((plus.size()-1)%2 ==0) result+=plus.get(plus.size()-1);

        for(int i = 0 ; i < minus.size()-1 ; i+=2){
            int a = minus.get(i);
            int b = minus.get(i+1);
            result+=(a*b);
        }
        if((minus.size()-1)%2 ==0) result+=minus.get(minus.size()-1);
        System.out.println(result);
    }
}
