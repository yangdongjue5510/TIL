package personalstudy.구현;
import java.io.*;
public class No2941 {
    static char[] arr;
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = bf.readLine().toCharArray();
    }
    static int go(){
        int result = arr.length;
        for(int i = 0 ; i < arr.length-1 ; i++){
            char now = arr[i];
            char next = arr[i+1];
            if(now == 'c') {
                if (next == '=' || next == '-') {
                    result--;
                    i++;
                }
            }
            else if(now == 'd') {
                if (next == '-') {
                    result--;
                    i++;
                } else if(next == 'z'&& i+2<arr.length && arr[i+2]=='='){
                    result -=2;
                    i += 2;
                }
            }
            else if(now == 'l' && next== 'j'){
                result--;
                i++;
            }
            else if(now == 'n' && next== 'j'){
                result--;
                i++;
            }
            else if(now == 's' && next== '='){
                result--;
                i++;
            }
            else if(now == 'z' && next== '='){
                result--;
                i++;
            }
            else continue;
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        input();
        System.out.println(go());

    }
}