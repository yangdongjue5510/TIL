package personalstudy.완전탐색;
import java.io.*;
import java.util.*;
public class No1759 {
    static int L, C;
    static char[] alphabets;
    static char[] password;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        alphabets = new char[C+1];
        password = new char[L+1];

        for(int i = 1 ; i <C+1 ; i++){
            alphabets[i] =(st.nextToken()).charAt(0);
        }
        Arrays.sort(alphabets);
    }
    static boolean validCheck(){
        int mo = 0;
        for(int i = 1 ; i < L+1 ; i++){
            char c = password[i];
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') mo++;
        }
        if(mo>=1 && L-mo>=2) return true;
        else return false;
    }
    static void rec_func(int index, int pre){
        if(index == L+1){
            if(validCheck()) {
                for (int i = 1; i < L + 1; i++)
                    sb.append(password[i]);
                sb.append("\n");
            }
        }else{
            for(int i = pre+1 ; i <C+1 ; i++){
                password[index] = alphabets[i];
                rec_func(index+1, i);
                password[index] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        rec_func(1, 0);
        System.out.println(sb);
    }

}
