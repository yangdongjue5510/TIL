package personalstudy.구현;

import java.io.*;
import java.util.*;

public class No1138 {
    static int N;
    static int[] arr;
    static LinkedList<Integer> list = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void check(){
        for(int i = N-1 ; i >=0; i--){
            int index = arr[i];
            list.add(index, i+1);
        }
    }

    static void appendElem(){
        for(int i : list){
            sb.append(i).append(" ");
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        check();
        appendElem();
        System.out.print(sb);
    }
}