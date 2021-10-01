package SOLID;

//OCP +DIP
interface Displayable {
    public void play();
}
class Jpg implements Displayable{
    @Override
    public void play(){
        System.out.println("jpg displayed");
    }
}
class Gif implements Displayable{
    @Override
    public void play(){
        System.out.println("gif displayed");
    }
}

class FileDisplayer{
    Displayable file;
    public void setFile(Displayable file){
        this.file = file;
    }
    public void play(){
        file.play();
    }
}
public class ImageDisplay {

    public static void main(String[] args) {
        FileDisplayer fileDisplayer = new FileDisplayer();
        Displayable file = new Jpg();
        fileDisplayer.setFile(file);
        fileDisplayer.play();

        file = new Gif();
        fileDisplayer.setFile(file);
        fileDisplayer.play();
    }
}

//Liskov
class Account {
    private int accountNum;
    private String owner;
    private int balance;
    private int setBalance(int balance){
        return this.balance = balance;
    }
}
class SavingAccount extends Account{
    private int interestRate;
    private int getInterest(){
        //return this.balance * this.interestRate; //오류!!!!
        return 0;
    }
}

//Interface 인터페이스 분리 원칙
interface Everything{
    void run();
    void sing();
    void swim();
}
class Singer implements Everything{
    @Override
    public void run() {
        System.out.println("Singer can run?");
    }

    @Override
    public void sing() {
        System.out.println("Singer can sing a song!!");
    }

    @Override
    public void swim() {
        System.out.println("Singer can swim....?");
    }
}
interface Singable{
    void sing();
}
interface Runnable{
    void run();
}
interface Swimable{
    void swim();
}
class RealSinger implements Singable{
    @Override
    public void sing() {
        System.out.println("Singer can sing a song~!");
    }
}