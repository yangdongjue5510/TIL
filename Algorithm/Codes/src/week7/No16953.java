package week7;
import java.io.*;
import java.util.*;
public class No16953 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = 1;
        while(B>A){
            if(B % 2 != 0){
                if(B % 10 != 1) {
                    result = -1;
                    break;
                }
                else{
                    B /= 10;
                }
            }
            else{
                B /= 2;
            }
            result ++;
        }
        if(A!=B) result =-1;
        System.out.println(result);
    }
}
