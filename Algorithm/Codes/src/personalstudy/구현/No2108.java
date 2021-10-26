package personalstudy.구현;
import java.io.*;
import java.util.*;
public class No2108 {
    static int N;
    static int[] arr;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            int elem = Integer.parseInt(bf.readLine());
            arr[i] = elem;
        }
        Arrays.sort(arr);
    }
    static int sumFunc(){
        double result = 0;
        for(int i : arr) result += i;
        double n = (double)N;

        return (int)Math.round(result/n);
    }

    static int frqFunc(){
        int elem = 4001;
        int elem2 = 4001;
        int maxCount = 0;
        int pre = arr[0];
        int count = 0;
        for(int i : arr){
            if(pre == i){
                count++;

            }
            else if(pre != i){
                count = 1;
            }

            if(count == maxCount){
                if(elem == 4001) elem = i;
                else if(elem2 == 4001) elem2 = i;
            }
            else if (count > maxCount){
                elem = i;
                elem2 = 4001;
                maxCount = count;
            }
            pre = i;
        }
        if(elem2 == 4001) return elem;
        return elem2;
    }
    public static void main(String[] args) throws IOException{
        input();
        System.out.println(sumFunc());
        System.out.println(arr[N/2]);
        System.out.println(frqFunc());
        System.out.println(arr[N-1]-arr[0]);
    }
}