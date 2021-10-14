package week8;
import java.io.*;
import java.util.*;
public class No11509 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> arrows = new ArrayList<>();
        int result = 0;
        for(int i = 0 ; i < N ; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        for(int i =0; i<list.size(); i++){
            if(arrows.isEmpty()){
                arrows.add(list.get(i)-1);
                result++;
            }
            else{
                if(arrows.contains(list.get(i)))
                    arrows.set(arrows.indexOf(list.get(i)), list.get(i)-1);
                else {
                    arrows.add(list.get(i)-1);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
