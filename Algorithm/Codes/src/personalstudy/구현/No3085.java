package personalstudy.구현;

import java.io.*;
import java.util.*;
public class No3085 {
    static int N;
    static char[][] arr;
    static int result = 0;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new char[N][N];
        for(int i = 0 ; i < N ; i++){
            String tmp = bf.readLine();
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = tmp.charAt(j);
            }
        }
    }

    static void checkAll(){
        for(int i = 0; i < N ; i++){
            int count = 1;
            for(int j = 0 ; j < N-1 ; j++){
                if(arr[i][j+1] == arr[i][j]) count++;
                else{
                    count = 1;
                }
                result = Math.max(result, count);
            }
        }

        for(int i = 0 ; i < N ; i++){
            int count = 1;
            for(int j = 0 ; j < N-1 ; j++){
                if(arr[j+1][i] == arr[j][i]) count++;
                else{
                    count = 1;
                }
                result = Math.max(result, count);
            }
        }
    }

    static void change(){
        for(int i =0 ; i < N ; i++){
            for(int j = 0 ; j < N-1 ; j++){
                char tmp = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = tmp;
                checkAll();
                arr[i][j+1] = arr[i][j];
                arr[i][j] = tmp;
            }
        }

        for(int i = 0 ; i < N-1 ; i++){
            for(int j = 0 ; j < N ; j++){
                char tmp = arr[i][j];
                arr[i][j] = arr[i+1][j];
                arr[i+1][j] = tmp;
                checkAll();
                arr[i+1][j] = arr[i][j];
                arr[i][j] = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        change();
        System.out.print(result);
    }
}
