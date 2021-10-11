package week8;
import java.io.*;
import java.util.*;
public class No1339 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0 ; j < N ; j++){
            char[] arr = bf.readLine().toCharArray();
            int arrLength = arr.length;
            for(int i = arrLength-1 ; i>=0 ; i--){
                int ten = (int) Math.pow(10, arrLength-1-i);
                if(map.containsKey(arr[i])){
                    int tmp = map.get(arr[i]);
                    map.replace(arr[i], tmp+ten);
                }
                else{
                    map.put(arr[i], ten);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int num = 9;
        int result = 0;
        for(int i : list){
            result += i*num;
            num--;
        }
        System.out.println(result);
    }
}

