package personalstudy.구현;
import java.io.*;
import java.util.*;
public class No1002 {
    static int testCase;
    static double x1, x2, y1, y2, r1, r2;

    static int check(){
        double between = Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);
        double sr = Math.min(r1,r2);
        double br = Math.max(r1, r2);
        if(between == 0 && r1 == r2 ) return -1;
        else if(between == Math.pow(r1+r2, 2)) return 1;
        else if(between == Math.pow(br-sr, 2)) return 1;
        else if(between < Math.pow(br-sr, 2)) return 0;
        else if(between > Math.pow(r1+r2, 2)) return 0;
        else return 2;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i = 0; i < testCase ; i++){
            st = new StringTokenizer(bf.readLine());
            x1 = Double.parseDouble(st.nextToken());
            y1 = Double.parseDouble(st.nextToken());
            r1 = Double.parseDouble(st.nextToken());
            x2 = Double.parseDouble(st.nextToken());
            y2 = Double.parseDouble(st.nextToken());
            r2 = Double.parseDouble(st.nextToken());
            System.out.println(check());
        }
    }
}