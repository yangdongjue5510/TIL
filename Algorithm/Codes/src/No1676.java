import java.util.Scanner;
public class No1676{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        count = (num/5) + (num/25) + (num/125);
        System.out.println(count);
    }
}