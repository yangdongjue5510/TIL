package personalstudy.완전탐색;
import java.io.*;
import java.util.*;
/*
정적 변수를 초기화 시켜주는 단계해주자.
 */
public class No14888 {
    static int N;
    static int[] numbers;
    static int[] cals = new int[4];
    static int[] order;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        numbers = new int[N];
        order = new int[N-1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < 4 ; i++){
            cals[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int calculate(){
        int result = numbers[0];
        for(int i =0 ; i< order.length ; i++){
            if(order[i] == 0) result = result+numbers[i+1];
            else if(order[i] == 1) result = result-numbers[i+1];
            else if(order[i] == 2) result = result*numbers[i+1];
            else{
                result = result/numbers[i+1];
            }
        }
        if(result > max) max = result;
        if(result < min) min = result;
        return result;
    }


    static void rec_func(int index){
        if(index == N-1) calculate();
        else{
            for(int i = 0 ; i < 4 ; i++){
                if(cals[i]>=1){
                    if(i == 0) {
                        cals[i]--;
                        order[index] = 0;
                        rec_func(index+1);
                        cals[i]++;
                        order[index]=0;
                    }
                    else if(i == 1)  {
                        cals[i]--;
                        order[index] = 1;
                        rec_func(index+1);
                        cals[i]++;
                        order[index]=0;
                    }
                    else if(i == 2)  {
                        cals[i]--;
                        order[index] = 2;
                        rec_func(index+1);
                        cals[i]++;
                        order[index]=0;
                    }
                    else {
                        cals[i]--;
                        order[index] = 3;
                        rec_func(index+1);
                        cals[i]++;
                        order[index]=0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        rec_func(0);
        System.out.println(max);
        System.out.println(min);
    }
}
