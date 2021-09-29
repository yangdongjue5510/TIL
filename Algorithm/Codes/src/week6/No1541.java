package week6;
import java.io.*;
import java.util.*;
public class No1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minusToken = new StringTokenizer(bf.readLine(),"-");
        long result = 0;
        StringTokenizer plusToken = new StringTokenizer(minusToken.nextToken(), "+");
        while(plusToken.hasMoreTokens()){
            result+=Long.parseLong(plusToken.nextToken());
        }
        while(minusToken.hasMoreTokens()) {
            long sum = 0;
            plusToken = new StringTokenizer(minusToken.nextToken(), "+");
            while(plusToken.hasMoreTokens()){
                sum+=Long.parseLong(plusToken.nextToken());
            }
            result-=sum;
        }
        System.out.println(result);
    }
}
