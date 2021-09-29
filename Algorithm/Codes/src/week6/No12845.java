package week6;
//queue
import java.util.*;
import java.io.*;
public class No12845 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while(list.size()!=1) {
            int maxIndex = list.indexOf(Collections.max(list));
            int minIndex = -1;
            if (maxIndex != 0 && maxIndex != list.size() - 1) {
                minIndex = list.indexOf(Math.min(list.get(maxIndex-1), list.get(maxIndex+1)));
            } else if(maxIndex == 0) minIndex = 1;
            else minIndex= list.size()-2;
            result += list.get(maxIndex)+list.get(minIndex);
            list.remove(minIndex);
        }
        System.out.println(result);
    }
}
