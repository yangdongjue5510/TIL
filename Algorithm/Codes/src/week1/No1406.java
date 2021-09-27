package week1;
import java.io.*;
import java.util.*;
public class No1406 {
    public static void main(String[] args) throws IOException{
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        var charArr = bf.readLine().toCharArray();
        var wordStk = new Stack<Character>();
        var testCase = Integer.parseInt(bf.readLine());
        var tmpStk = new Stack<Character>();

        for (char c : charArr)
            wordStk.add(c);
        for (int i = 0 ; i < testCase ; i++){
            var cmdLine = new StringTokenizer(bf.readLine());
            var cmd = cmdLine.nextToken();
            if (cmd.equals("P")){
                wordStk.push(cmdLine.nextToken().charAt(0));
            }
            else if (cmd.equals("D")){
                if (tmpStk.size() != 0){
                    wordStk.push(tmpStk.pop());
                }
            }
            else if (wordStk.size()==0)
                continue;
            else if (cmd.equals("L")){
                tmpStk.push(wordStk.pop());
            }
            else if (cmd.equals("B")){
                wordStk.pop();
            }
        }
        for (char c : wordStk)
            sb.append(c);
        while(!tmpStk.isEmpty())
            sb.append(tmpStk.pop());
        System.out.println(sb);
    }
}