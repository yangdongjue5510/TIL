package personalstudy.구현;
import java.io.*;
import java.util.*;
//모르겠다 씨발.
public class No14503NotSolved {
    static int[][] room;
    static int result = 0;
    static int M, N;
    static Robot robot;
    static int[] nextAddX = {-1, 0, 1, 0};
    static int[] nextAddY = {0, 1, 0, -1};
    static class Robot{
        int x, y, direction;
        public Robot(int x, int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int direction =  Integer.parseInt(st.nextToken());
        robot = new Robot(r,c,direction);

        room = new int[N][M];
        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0 ; j < M ; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void rotate(){
        robot.direction += 3;
        robot.direction %= 4;
    }

    static void go(){
        if(room[robot.x][robot.y] == 0) {
            room[robot.x][robot.y] = 2;
            result ++;
        }
        boolean isMoved = false;
        for(int i = 0 ; i < 4 ; i++){
            rotate();
            int nextD = robot.direction;
            int nextX = robot.x + nextAddX[nextD];
            int nextY = robot.y + nextAddY[nextD];
            if(nextX >=0 && nextY>=0 &&nextX <= N-1 && nextY <= M-1){
                if(room[nextX][nextY] == 0){
                    robot.x = nextX;
                    robot.y = nextY;
                    isMoved = true;
                }
            }
        }
        if(isMoved) go();
        else back();
    }

    static void back(){
        boolean isMoved = false;
        int nextD = robot.direction;
        int nextX = robot.x - nextAddX[nextD];
        int nextY = robot.y - nextAddY[nextD];
        if(nextX >=0 && nextY>=0 &&nextX <= N-1 && nextY <= M-1){
            if(room[nextX][nextY] != 1){
                robot.x = nextX;
                robot.y = nextY;
                isMoved = true;
            }
        }
        if(isMoved) go();
        else System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        input();
        go();
    }
}