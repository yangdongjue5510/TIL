package week1;
import java.io.*;
import java.util.*;
public class No9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        var testCase = Integer.parseInt(bf.readLine());
        for (int i = 0 ; i < testCase ; i++){
            char[] arr = bf.readLine().toCharArray();
            int openCount = 0;
            for (char c : arr){
                if (c == '(')
                    openCount++;
                else if (c == ')'){
                    openCount--;
                    if (openCount < 0)
                        break;
                }
            }
            if (openCount == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}