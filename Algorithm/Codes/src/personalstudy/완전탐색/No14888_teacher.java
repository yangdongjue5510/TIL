package personalstudy.완전탐색;

import java.io.*;
import java.util.*;
import static personalstudy.완전탐색.No14888.*;
public class No14888_teacher {
    static void input() throws IOException {
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

    static int calculate(int value, int cal, int nextVal){
        if(cal  == 0) return value+nextVal;
        if(cal == 1) return value-nextVal;
        if(cal == 2) return value*nextVal;
        else return value/nextVal;
    }

    static void rec_func(int index, int num){
        if(index == N-1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        else{
            for(int i = 0 ; i < 4 ; i++){
                if(cals[i]>=1){
                    cals[i]--;
                    order[index] = i;
                    int newValue = calculate(num, i, numbers[index+1]);
                    rec_func(index+1, newValue);

                    cals[i]++;
                    order[index]=0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        rec_func(0, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }
}
