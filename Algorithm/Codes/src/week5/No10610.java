package week5;

import java.util.*;
import java.io.*;
public class No10610 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(),"");
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int test = 0;
        while(st.hasMoreTokens()){
            int tmp =Integer.parseInt(st.nextToken());
            System.out.println(tmp);
            list.add(tmp);
            test+=tmp;
        }
        Collections.sort(list);
        Collections.reverse(list);
        if(test%3 == 0 && list.get(list.size()-1) == 0){
            for(int i : list){
                sb.append(i);
            }
            System.out.print(sb);
        }
        else
            System.out.print(-1);
    }
}