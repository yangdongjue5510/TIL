package personalstudy.구현;
import java.io.*;
import java.util.*;
public class No1475 {
    static List<Integer> roomNumber = new ArrayList<>();
    static int sixNine = 0;
    static int[] countArr = new int[10];

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int roomInt = Integer.parseInt(bf.readLine());
        setRoomNumber(roomInt);
    }

    static void setRoomNumber(int room){
        while(room>0){
            int roomLetter = room%10;
            room = room/10;
            if(roomLetter == 6 || roomLetter == 9) {
                sixNine++;
                continue;
            }
            roomNumber.add(roomLetter);
        }
    }

    static void checkRoomLetter(){
        for(int roomLetter : roomNumber){
            if(roomLetter ==6 || roomLetter == 9) continue;
            countArr[roomLetter]++;
        }
    }

    static int findMax(){
        int max = countArr[0];
        for(int i : countArr){
            if (max<i) max = i;
        }
        int sixNineResult = (sixNine/2) + (sixNine%2);
        return Math.max(sixNineResult, max);
    }
    public static void main(String[] args) throws IOException {
        input();
        checkRoomLetter();
        System.out.println(findMax());
    }
}