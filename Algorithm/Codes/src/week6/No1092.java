package week6;
import java.io.*;
import java.util.*;

public class No1092 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] cranes = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < N ; i++){
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(bf.readLine());
        int[] boxes = new int[M];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < M ; i++){
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranes);
        Arrays.sort(boxes);
        int result = 0;
        int[] countArr = new int[N];
        int craneIndex = 0;

        outer:
        for(int i = 0; i < M ; i++){
            while(cranes[craneIndex]<boxes[i]){
                craneIndex+=1;
                if(craneIndex > N-1){
                    result = -1;
                    break outer;
                }
            }
            countArr[craneIndex]++;
        }

        if(result != -1){
            int height = 0;
            int sum = 0;
            for(int i = N-1 ; i >= 0 ; i--){
                sum+=countArr[i];
                if(sum/(N-i) >= height){
                    height  = sum/(N-i);
                    if(sum%(N-i)!=0) height+=1;
                }
            }
            result=height;
        }
        System.out.println(result);
    }
}
