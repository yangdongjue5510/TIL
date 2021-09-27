package week4;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;
public class No1931{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] == b[1])
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        });
        int time = 0;
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            if(time>arr[i][0])
                continue;
            time = arr[i][1];
            count++;
        }
        System.out.println(count);
    }
}

//public class week4.No1931{
//    public static final long MAX = (long)Math.pow(2,32);
//    public static void main(String[] args) throws IOException{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int meetCount = Integer.parseInt(bf.readLine());
//        long[] start = new long[meetCount];
//        long[] end = new long[meetCount];
//        for(int i = 0 ; i < meetCount ; i++){
//            StringTokenizer st = new StringTokenizer(bf.readLine());
//            start[i] = Integer.parseInt(st.nextToken());
//            end[i] = Integer.parseInt(st.nextToken());
//        }
//        long time = 0;
//        long startMax = 0;
//        int count = 0;
//        for(int i = 0 ; i < meetCount ; i++){
//            if (startMax < start[i] ){
//                startMax = start[i];
//            }
//        }
//        while(time < startMax){
//            long endMin=MAX;
//            for(int i = 0 ; i < meetCount ; i++){
//                if (start[i] < time)
//                    continue;
//                if (end[i] < endMin)
//                    endMin = end[i];
//            }
//            time = endMin;
//            count++;
//        }
//        System.out.println(count);
//    }
//}