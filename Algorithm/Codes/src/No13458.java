import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[testCase];
        for(int i = 0 ; i < testCase ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        int pro = Integer.parseInt(st2.nextToken());
        int ama = Integer.parseInt(st2.nextToken());
        int result = testCase;
        for(int i = 0 ; i < testCase ; i++){
            arr[i]-=pro;
            if(arr[i]<=0)
                continue;
            result += arr[i]/ama;
            if(arr[i]%ama >0)
                result++;
        }
        System.out.println(result);
    }
}