package week1;
import java.io.*;
import java.util.*;
public class No9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < testCase ; i++){
            StringTokenizer inputStr = new StringTokenizer(bf.readLine()," ",true);
            while(inputStr.hasMoreTokens()){
                char[] wordChar = inputStr.nextToken().toCharArray();
                StringBuilder sb = new StringBuilder();
                for (int j = wordChar.length -1 ; j > -1 ; j--){
                    sb.append(wordChar[j]);
                }
                System.out.print(sb);
            }
            System.out.println();
        }
    }
}