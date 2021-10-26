package personalstudy.구현;
import java.io.*;
import java.util.*;
public class No1476 {
    static int E, S, M;
    static int e, s, m, result;
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        e = 0;
        s = 0;
        m = 0;
    }

    static void go(){
        if(++e >15) e = 1;
        if(++s >28) s = 1;
        if(++m >19) m = 1;
        result++;
    }

    public static void main(String[] args) throws IOException{
        input();
        while(true){
            if (e==E&&s==S&&m==M) break;
            go();
        }
        System.out.println(result);
    }
}