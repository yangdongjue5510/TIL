package week4;

import java.util.*;
import java.io.*;
public class No1080{
    static int N;
    static int M;
    static char [][] arr1;
    static char [][] arr2;
    public static void change(int a, int b){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(arr1[a+i][b+j] == '0') arr1[a+i][b+j] = '1';
                else arr1[a+i][b+j] = '0';
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1=new char[N][M];
        arr2=new char[N][M];
        int result = 0;
        for(int i = 0 ; i < N ; i++){
            arr1[i] = bf.readLine().toCharArray();
        }
        for(int i = 0 ; i < N ; i++){
            arr2[i] = bf.readLine().toCharArray();
        }
        for(int i = 0 ; i < N-2 ; i++){
            for(int j = 0 ; j < M-2 ; j++){
                if(arr1[i][j]!= arr2[i][j]){
                    change(i,j);
                    result++;
                }
            }
        }
        if (!Arrays.deepEquals(arr1,arr2)) System.out.println(-1);
        else System.out.println(result);
    }
}