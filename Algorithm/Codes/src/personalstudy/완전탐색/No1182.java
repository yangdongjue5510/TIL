package personalstudy.완전탐색;
import java.io.*;
import java.util.*;

public class No1182 {
    static int N, S, answer;
    static int[] arr;
    static boolean[] check;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        arr = new int[N+1];
        check = new boolean[N+1];
        for(int i = 1 ; i < N+1 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int plus(){
        int result=0;
        for(int i = 1; i < N+1; i++){
            if(check[i]) result+=arr[i];
        }
        return result;
    }

    static boolean isAllFalse(){
        for(boolean i : check){
            if(i) return false;
        }
        return true;
    }

    static void rec_func(int index){
        if(index == N+1) {
            if(plus()==S && !isAllFalse()) {
                answer++;
            }
        }else {
            check[index] = false;
            rec_func(index + 1);
            check[index] = true;
            rec_func(index + 1);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        rec_func(1);
        System.out.println(answer);
    }
}
