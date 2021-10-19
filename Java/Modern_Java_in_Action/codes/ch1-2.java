import java.io.*;
//함수형 인터페이스 생성
interface BufferedReaderProccessor{
    String process(BufferedReader b) throws IOException;
}

public class ch1_2 {
    //함수형 인터페이스를 람다를 구현할 동작 만들기
    public static String proccessFile(BufferedReaderProccessor p) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        //람다로 두줄 읽기 기능 구현
        String oneLine = proccessFile((BufferedReader br)->br.readLine()+br.readLine());
    }
}
