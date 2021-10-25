package personalstudy.구현;
import java.io.*;
import java.util.*;
public class No1316 {
    static int N;
    static String[] str;
    static int noneGroup = 0;
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        str = new String[N];
        for(int i = 0 ; i < N ; i++){
            str[i] = bf.readLine();
        }
    }
    static void go(){
        for(String i : str){
            List<Character> alphabet = new LinkedList<>();
            char[] charArr = i.toCharArray();
            char prev = 0;
            loop:
            for(int j = 0 ; j < charArr.length ; j++){
                if (prev == charArr[j]) continue;
                for(char k : alphabet){
                    if(k==charArr[j]){
                        noneGroup ++;
                        break loop;
                    }
                }
                alphabet.add(charArr[j]);
                prev = charArr[j];
            }
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        go();
        System.out.println(N-noneGroup);
    }
}
