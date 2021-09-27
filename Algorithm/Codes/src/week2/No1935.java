package week2;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class No1935 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numCount = Integer.parseInt(bf.readLine());
        char[] arr = bf.readLine().toCharArray();
        double[] num = new double[numCount];
        Stack<Double> stk = new Stack<>();
        DecimalFormat form = new DecimalFormat(("#.00"));
        for(int i = 0; i < num.length ; i++){
            num[i] = Double.parseDouble(bf.readLine());
        }
        double result = 0.0d;
        int index = 'A';
        for(char c : arr){
            if(c>='A' && c<='Z'){
                stk.push(num[c-65]);
                continue;
            }
            else {
                double b = stk.pop();
                double a = stk.pop();
                switch (c) {
                    case '+':
                        stk.push(a+b);
                        break;
                    case '-':
                        stk.push(a - b);
                        break;
                    case '/':
                        stk.push(a /b);
                        break;
                    case '*':
                        stk.push(a * b);
                        break;
                }
            }
        }
        System.out.println(form.format(stk.pop()));
    }
}