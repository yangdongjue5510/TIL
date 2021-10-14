package week8;
import java.io.*;
import java.util.*;
public class No11497 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int[] arr;
        for(int i = 0 ; i < testCase ; i++){
            int N = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            arr = new int[N];
            for(int j = 0 ; j<N ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int pre = arr[0];
            int post = arr[0];
            int result = 0;
            for(int k = 1 ; k < N-1 ; k+=2){
                int tmp = Math.max(arr[k]-pre, arr[k+1]-post);
                result = Math.max(result, tmp);
                pre = arr[k];
                post = arr[k+1];
            }
            if(N%2==0){
                int tmp = Math.max(arr[N-1]-pre, arr[N-1]-post);
                result = Math.max(tmp, result);
            }
            System.out.println(result);
        }
    }
}