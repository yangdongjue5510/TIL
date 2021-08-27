import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        var bf = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = bf.readLine().toCharArray();
        List list = Arrays.asList(charArr);
        var wordStk = new ArrayList<Character>(list);
        var testCase = Integer.parseInt(bf.readLine());
        var tmpStk = new ArrayList<Character>();
        for (int i = 0 ; i < testCase ; i++){
            var cmdLine = new StringTokenizer(bf.readLine());
            var cmd = cmdLine.nextToken();
            if (cmd.equals("P")){
                wordStk.add(cmdLine.nextToken().charAt(0));
            } else if (cmd.equals("L")){
                if (wordStk.size() != 0){
                    tmpStk.add(wordStk.get(wordStk.size()-1));
                    wordStk.remove(wordStk.size()-1);
                }
            } else if (cmd.equals("D")){
                if (tmpStk.size() != 0){
                    wordStk.add(tmpStk.get(tmpStk.size()-1));
                    tmpStk.remove(tmpStk.size()-1);
                }
            } else if (cmd.equals("B")){
                if (wordStk.size() != 0){
                    wordStk.remove(wordStk.size()-1);
                }
            }
        }
        for (char c : wordStk)
            System.out.print(c);
        for (char c : tmpStk)
            System.out.print(c);
    }
}