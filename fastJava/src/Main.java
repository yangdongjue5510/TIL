import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        var bf = new BufferedReader(new InputStreamReader(System.in));
        //char[] charArr = (bf.readLine()).toCharArray();
        var list = bf.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        var wordStk = new ArrayList<Character>(list);
        var testCase = Integer.parseInt(bf.readLine());
        var tmpStk = new ArrayList<Character>();

        for (int i = 0 ; i < testCase ; i++){
            var cmdLine = new StringTokenizer(bf.readLine());
            var cmd = cmdLine.nextToken();
            if (cmd.equals("P")){
                wordStk.add(cmdLine.nextToken().charAt(0));
            }
            else if (cmd.equals("D")){
                if (tmpStk.size() != 0){
                    wordStk.add(tmpStk.get(tmpStk.size()-1));
                    tmpStk.remove(tmpStk.size()-1);
                }
            }
            else if (wordStk.size()==0)
                continue;
            else if (cmd.equals("L")){
                tmpStk.add(wordStk.get(wordStk.size()-1));
                wordStk.remove(wordStk.size()-1);
            }
            else if (cmd.equals("B")){
                wordStk.remove(wordStk.size()-1);
            }
        }
        for (char c : wordStk)
            System.out.print(c);
        for (int i = tmpStk.size()-1 ; i > -1 ; i--){
            System.out.print(tmpStk.get(i));
        }
    }
}