import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] array = scanner.nextLine().toCharArray();
        char[] sorted = array.clone();
        Arrays.sort(sorted);
        for(char c : sorted){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < array.length ; i++){
                if(array[i]==c){
                    for (int j = i ; j < array.length ; j++){
                        sb.append(array[j]);
                    }
                    System.out.println(sb);
                    break;
                }
            }
        }
    }
}