package personalstudy.graph;
import java.io.*;
import java.util.*;

public class No1260 {
    static ArrayList<Integer>[] list;
    static int N, E, V;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1 ; i <= N ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1 ; i <= E ; i++){
            st = new StringTokenizer(bf.readLine());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[index].add(value);
            list[value].add(index);
        }

        for(int i = 1 ; i <= N; i++){
            Collections.sort(list[i]);
        }
    }

    static void dfs(int x){
        sb.append(x).append(" ");
        visited[x] = true;

        for(int i : list[x]){
            if(visited[i] == true) continue;
            dfs(i);
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while(!que.isEmpty()){
            int x = que.poll();
            for(int i : list[x]){
                if(visited[i] == true) continue;
                que.add(i);
                visited[i] = true;
                sb.append(i).append(" ");
            }
        }

    }
    public static void main(String[] args) throws IOException{
        input();
        dfs(V);
        visited = new boolean[N+1];
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }
}
