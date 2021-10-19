import java.util.*;

class Player{
    private int age;
    private String position;
    private int salary;
    public Player(int age, int salary, String position){
        this.age=age;
        this.salary=salary;
        this.position=position;
    }
    int getAge(){
        return this.age;
    }
    String getPosition(){
        return this.position;
    }
    int getSalary(){
        return this.salary;
    }
    public String toString(){
        return "age : "+this.age+" Position : "+this.position+" salary : "+this.salary;
    }
}
//normal answer.
class Ch1_1{
    public static List<Player> filterPg(List<Player> list){
        List<Player> pgPlayer = new ArrayList<>();
        for(Player p : list){
            if(p.getPosition().equals("PG")){
                pgPlayer.add(p);
            }
        }
        return pgPlayer;
    }
}

//using predicate interface answer.
interface playerPredicate{
    boolean test(Player player);
}
class pgPlayer implements playerPredicate{
    @java.lang.Override
    public boolean test(Player player) {
        if (player.getPosition().equals("PG"))
            return true;
        return false;
    }
}
class cheapPlayer implements playerPredicate{
    @java.lang.Override
    public boolean test(Player player) {
        if (player.getSalary()>20)
            return true;
        return false;
    }
}
//using generic for more than player!!
interface PlayerPredicate2<T>{
    boolean test(T t);
}


public class Ch1 {
    //using predicate!
    public static List<Player> filterPlayer(List<Player> list, playerPredicate p) {
        List<Player> result = new ArrayList<>();
        for (Player i : list) {
            if (p.test(i)) {
                result.add(i);
            }
        }
        return result;
    }
    //using generic
    public static <T> List<T> filterGeneric(List<T> list, PlayerPredicate2<T> p){
        List<T> result = new ArrayList<>();
        for (T t : list){
            if(p.test(t))
                result.add(t);
        }
        return result;
    }

    public static void printPlayer(List<Player> list){
        for(Player i : list){
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        List<Player> list = new ArrayList<>();
        list.add(new Player(20, 15, "PG"));
        list.add(new Player(30, 25, "SG"));
        list.add(new Player(50, 45, "CT"));

        List<Player> result = filterPlayer(list, new cheapPlayer());
        printPlayer(result);

        //using anonymous class!
        List<Player> anonyResult = filterPlayer(list, new playerPredicate(){
            public boolean test(Player p){
                if(p.getPosition().equals("CT"))
                    return true;
                return false;
            }
        });
        printPlayer(anonyResult);

        //using ramda!
        List<Player> ramdaResult = filterPlayer(list, (i)->i.getPosition().equals("PG"));
        printPlayer(ramdaResult);

        //using generic
        List<Player> genericResult = filterGeneric(list, i->i.getPosition().equals("PG"));
        printPlayer(genericResult);
    }
}