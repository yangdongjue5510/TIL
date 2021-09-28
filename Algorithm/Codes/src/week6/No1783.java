package week6;
import java.io.*;
import java.util.*;
public class No1783 {
    static int N;
    static int M;
    static int x;
    static int y;
    public static void go(){
        if(N>=3){
            if(x>=2){
                x-=2;
                y+=1;
            }
            else if(N-1-x>=2){
                x+=2;
                y+=1;
            }
        }
        else {
            if(x>=1){
                x-=1;
                y+=2;
            }
            else if(N-1-x>=1){
                x+=1;
                y+=2;
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = N-1;
        y = 0;
        int step = 1;

        if(N!=1 && M !=1){
            if(N>=3 && M>=7){
                y = 6;
                step = 5;
            }
            while(x<=N-1 && y<=M-1){
                go();
                step++;
            }
            step-=1;
        }
        if(N>=3 && M<7 && step>=5) step = 4;
        if(N<3 && M>=7 && step>=5) step = 4;
        System.out.println(step);
    }
}