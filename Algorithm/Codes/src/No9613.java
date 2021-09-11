import java.util.*;
import java.io.*;
public class No9613{
    public static long gcd(long a, long b){
        if(b>a){
            long tmp = b;
            b = a;
            a = tmp;
        }
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while(testCase!=0){
            ArrayList<Long> lst = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int numCase = Integer.parseInt(st.nextToken());
            long result = 0;
            while(numCase!=0){
                long num = Integer.parseInt(st.nextToken());
                lst.add(num);
                numCase--;
            }
            for(int i = 0 ; i < lst.size(); i++){
                for(int j = i+1 ; j < lst.size() ; j++){
                    result+=gcd(lst.get(i), lst.get(j));
                }
            }
            sb.append(result+"\n");
            testCase--;
        }
        System.out.print(sb);
    }
}