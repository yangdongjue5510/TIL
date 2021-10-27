package personalstudy.구현;
import java.io.*;
import java.util.*;
public class No2563 {
    static int testCase, result;
    static boolean[][] board = new boolean[100][100];

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < testCase ; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            check(x, y);
        }
    }

    static void check(int x, int y){
        for(int i = x ; i < x+10 ; i++){
            for(int j = y ; j < y+10 ; j++){
                if(board[i][j]==false){
                    board[i][j] = true;
                    result++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        System.out.println(result);
    }
}