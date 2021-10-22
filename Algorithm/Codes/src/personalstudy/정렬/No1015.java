package personalstudy.정렬;
import java.io.*;
import java.util.*;
public class No1015 {
    static int N;
    static Elem[] arr;
    static int[] P;
    static class Elem implements Comparable<Elem>{
        int valueA, indexA;
        public Elem(int valueA, int indexA){this.valueA=valueA; this.indexA=indexA;}
        public int compareTo(Elem other){
            if(valueA == other.valueA){
                return indexA-other.indexA;
            }else{
                return valueA-other.valueA;
            }
        }
    }

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr= new Elem[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = new Elem(Integer.parseInt(st.nextToken()), i);
        }
        P = new int[N];
    }

    public static void main(String[] args)throws IOException{
        input();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            P[arr[i].indexA] = i;
        }
        for(int i = 0 ; i < N ; i++){
            sb.append(P[i]).append(" ");
        }
        System.out.println(sb);
    }
}