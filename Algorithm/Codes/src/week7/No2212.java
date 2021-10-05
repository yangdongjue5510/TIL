package week7;
import java.io.*;
import java.util.*;
public class No2212 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int censorCount = Integer.parseInt(bf.readLine());
        int centerCount = Integer.parseInt(bf.readLine());
        TreeSet<Integer> censors = new TreeSet<>();
        ArrayList<Integer> distances = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < censorCount ; i++){
            censors.add(Integer.parseInt(st.nextToken()));
        }
        int pre = censors.pollFirst();
        while(!censors.isEmpty()){
            int post = censors.pollFirst();
            distances.add(post-pre);
            pre = post;
        }
        int result = 0 ;
        Collections.sort(distances);
        if(censorCount>centerCount){
            for(int i = 0 ; i < centerCount-1 ; i++){
                distances.remove(distances.size()-1);
            }
            for(int i : distances) result+=i;
        }
        System.out.println(result);
    }
}
