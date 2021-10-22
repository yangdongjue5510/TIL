package personalstudy.정렬;
import java.io.*;
import java.util.*;
public class No10825 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static Student[] arr;
    static class Student implements Comparable<Student>{
        String name;
        int kor, eng, mat;
        public Student(String name, int kor, int eng, int mat){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
        }
        public int compareTo(Student other){
            if (this.kor == other.kor){
                if(this.eng == other.eng){
                    if(this.mat == other.mat){
                        return this.name.compareTo(other.name);
                    }else return other.mat - this.mat;
                }else return this.eng - other.eng;
            }else return other.kor-this.kor;
        }
    }
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new Student[N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());
            arr[i] = new Student(name, kor, eng, mat);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N; i++){
            sb.append(arr[i].name).append("\n");
        }
        System.out.print(sb);
    }
}
