package week5;

import java.util.*;
import java.io.*;
public class No11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        int[][] table = new int[testCase][2];
        for(int i = 0 ; i < testCase ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(table, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] == b[1])
                    return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            }
        });
        int time = 0;
        int result = 0;
        for(int i = 0 ; i < table.length ; i++){
            if(time > table[i][0])
                continue;
            time = table[i][1];
            result++;
        }
        System.out.println(result);
    }
}