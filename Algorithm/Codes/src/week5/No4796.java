package week5;

import java.io.*;
import java.util.*;
public class No4796 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int result = 0;
            if(L == 0 && P == 0 && V == 0) break;
            while(V>=P){
                V-=P;
                result+=L;
            }
            result+=V;
            System.out.println("Case "+caseNum++ +": "+result);
        }
    }
}