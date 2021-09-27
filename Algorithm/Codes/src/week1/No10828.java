package week1;
/*
스택
 */
import java.io.*;
import  java.util.*;
public class No10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        var commandCount = Integer.parseInt(st.nextToken());
        var stack = new ArrayList<Integer>();

        for (int i = 0 ; i < commandCount ; i++){
            var tk = new StringTokenizer(bf.readLine());
            var command = tk.nextToken();
            if(command.equals("push")){
                var inputNum = Integer.parseInt(tk.nextToken());
                stack.add(inputNum);
            } else if(command.equals("pop")){
                if (stack.size() != 0){
                    var output = stack.get(stack.size() - 1);
                    stack.remove(stack.size()-1);
                    System.out.println(output);
                }
                else
                    System.out.println(-1);

            } else if(command.equals("size")){
                System.out.println(stack.size());
            } else if(command.equals("empty")){
                if (stack.size() == 0)
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if(command.equals("top")){
                if (stack.size() == 0)
                    System.out.println(-1);
                else
                    System.out.println(stack.get(stack.size()-1));
            }

        }
        bf.close();
    }
}