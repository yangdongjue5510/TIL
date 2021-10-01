package SOLID;
//SRP
class ICanDoEverything{
    public void plus(int a, int b){
        System.out.println(a+b);
    };
    public void display(Displayable file){file.play();}
    public void singASong(Singable singer){singer.sing();}
}
public class SRPTest {
    public static void main(String[] args) {
        ICanDoEverything hero = new ICanDoEverything();
        Displayable file = new Jpg();
        Singable singer = new RealSinger();
        int a1 = 1; int a2 =2;
        hero.display(file);
        hero.singASong(singer);
        hero.plus(a1, a2);
    }
}
