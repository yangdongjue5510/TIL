package personalstudy.graph;
import java.io.*;
import java.util.*;

public class No5567 {
    static int N;
    static int E;
    static int result = 0;
    static ArrayList<Integer>[] arr;
    static boolean[] visited ;
    static Queue<Integer> que = new LinkedList<>();

    static void input() throws IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        E = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 0  ; i <= N ; i++){
            arr[i]= new ArrayList<>();
        }
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
    }


    static void bfs(int x){
        visited[x] = true;
        for(int i : arr[x]) {
            visited[i] = true;
            result++;
            que.add(i);
        }

        for(int i : que){
            for(int j : arr[i]){
                if(visited[j]) continue;
                visited[j] = true;
                result++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        bfs(1);
        System.out.println(result);
    }
}
