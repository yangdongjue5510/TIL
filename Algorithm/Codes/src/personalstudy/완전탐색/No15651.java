package personalstudy.완전탐색;
import java.io.*;
import java.util.*;
public class No15651 {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static void plus(int index, int[] arr){
        arr[index]++;
        if(arr[index]>N){
            if(index>0){
                arr[index] -= N;
                plus(index-1, arr);
            }
            else return;
        }
    }
    static void printArr(int[] arr){
        for(int i : arr){
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = 1;
        }
        while(arr[0]<=N){
            printArr(arr);
            plus(M-1, arr);
        }
        System.out.println(sb);
    }
}