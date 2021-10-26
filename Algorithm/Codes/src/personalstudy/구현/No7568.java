package personalstudy.구현;
import java.io.*;
import java.util.*;


public class No7568{
    static int N;
    static List<Body> list;
    static StringBuilder sb = new StringBuilder();
    static class Body{
        int x, y;
        public Body(int x, int y){this.x = x; this.y = y;}
        boolean isSmaller(Body other){
            if(x < other.x && y < other.y) return true;
            return false;
        }
    }

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Body(x,y));
        }
    }

    static void go(){
        for(Body body : list){
            int rank = 1;
            for(Body other : list){
                if(body.isSmaller(other)) rank++;
            }
            sb.append(rank).append(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        go();
        System.out.print(sb);
    }
}