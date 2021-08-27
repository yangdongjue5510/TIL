import java.util.Scanner;
public class No1004 {
    public static boolean inOrOut(int x1, int x2, int y1, int y2, int r){
        if (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) <= r){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] x = new int[2];
        int[] y = new int[2];
        for (int i = 0 ; i < testCase ; i++){
            x[0] = sc.nextInt();
            y[0] = sc.nextInt();
            x[1] = sc.nextInt();
            y[1] = sc.nextInt();
            int planetCount = sc.nextInt();
            int result = 0;
            for (int j = 0 ; j < planetCount ; j++){
                int planetX = sc.nextInt();
                int planetY = sc.nextInt();
                int planetR = sc.nextInt();
                if(inOrOut(x[0], planetX, y[0], planetY, planetR)){
                    if(!inOrOut(x[1], planetX, y[1], planetY, planetR)){
                        result += 1;
                    }
                }
                else{
                    if(inOrOut(x[1], planetX, y[1], planetY, planetR)){
                        result += 1;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
