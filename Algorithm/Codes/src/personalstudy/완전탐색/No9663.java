package personalstudy.완전탐색;
import java.io.*;
import java.util.*;

public class No9663 {
    static int N, ans;
    static int[] rows;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        rows = new int[N+1];

    }

    static boolean check(int index, int row){
        for(int i = 1 ; i<index ; i++){
            if(i==index || rows[i] == row) return false;
            if(i-index == rows[i]-row || i-index == -(rows[i]-row))
                return false;
        }
        return true;
    }

    static void rec_func(int index){
        if(index == N+1){
            ans++;
        }
        else{
            for(int i = 1; i<N+1 ; i++){
                if(check(index, i)){
                    rows[index] = i;
                    rec_func(index+1);
                    rows[index] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        rec_func(1);
        System.out.println(ans);
    }
}