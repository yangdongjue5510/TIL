package personalstudy.완전탐색;
import java.util.*;
import java.io.*;
/*
완전탐색 : N개에서 중복 허용하지 않고 M개 순서 신경써서 뽑기...
 */
public class No15649 {
    static int N, M;
    static int[] arr;
    static boolean[] flag;
    static StringBuilder sb = new StringBuilder();
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
    }

    static void rec_func(int index){
        if (index == M+1){
            for(int i = 1 ; i < arr.length ; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
        } else{
            for(int cand = 1 ; cand < flag.length; cand++){
                if(flag[cand]==false){
                    flag[cand] = true;
                    arr[index] = cand;
                    rec_func(index+1);
                    flag[cand] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        arr = new int[M+1];
        flag = new boolean[N+1];
        rec_func(1);
        System.out.println(sb);
    }
}