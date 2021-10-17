import java.io.*;
import java.util.*;
public class No11726 {
    static int N;
    static int first = 1;
    static int second = 2;
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
    }

    static int rec_func(int num){
        if (num==1) return 1;
        else if (num==2) return 2;
        else{
            for(int i = 3; i <=num; i++){
                int tmp = first+second;
                first = second;
                second = tmp;
            }
            return second;
        }
    }
    public static void main(String[] args) throws IOException{
        input();

        System.out.println(rec_func(N)%10007);
    }
}

