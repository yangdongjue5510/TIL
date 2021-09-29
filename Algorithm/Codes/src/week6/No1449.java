package week6;
import java.io.*;
import java.util.*;
public class No1449 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int issueCount = Integer.parseInt(st.nextToken());
        int tapeSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] issues = new int[issueCount];
        for(int i = 0 ; i < issueCount ; i++){
            issues[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(issues);
        int result = 1;
        int tapeCovered = 0;
        tapeCovered = tapeSize-1+issues[0];
        for(int i = 1 ; i < issueCount ; i++){
            if(issues[i] > tapeCovered){
                result++;
                tapeCovered =tapeSize-1+issues[i];
            }
        }
        System.out.println(result);
    }
}
