package week5;

import java.util.*;
import java.io.*;
public class No1946 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader
                (new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for(int i = 0; i < testCase ; i++){
            int apply = Integer.parseInt(bf.readLine());
            int[][] rank = new int[apply][2];
            int count = 1;
            int check = 0;
            for(int j = 0; j < apply ; j++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(rank, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    return Integer.compare(a[0],b[0]);
                }
            });
            check = rank[0][1];
            for(int j = 1; j < apply ; j++){
                if(rank[j][1] < check){
                    check = rank[j][1];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}