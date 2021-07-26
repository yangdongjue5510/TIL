import java.util.*;

interface Predicate<T> {
    boolean test(T t);
}
interface Consumer<T>{
    void accept(T t);
}
interface Function<T, R>{
    R apply(T t);
}

public class ch1_3 {
    public static <T> List<T> filterPredicate(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : list){
            if (p.test(t))
                result.add(t);
        }
        return result;
    }
    public static <T> void filterConsumer(List<T> list, Consumer<T> p){
        for(T t: list){
            p.accept(t);
        }
    }
    public static <T, R> List<R> filterFunction(List<T> list, Function<T, R> p){
        List<R> result = new ArrayList<>();
        for (T t: list){
            result.add(p.apply(t));
        }
        return result;
    }
    public static <T> void printSomething(List<T> list){
        for(T i : list){
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        List<Player> list = new ArrayList<>();
        list.add(new Player(20, 15, "PG"));
        list.add(new Player(30, 25, "SG"));
        list.add(new Player(50, 45, "CT"));

        List<Player> findPG = filterPredicate(list, i-> i.getPosition().equals("PG"));
        printSomething(findPG);
        filterConsumer(list, i->System.out.println(i.getPosition()));
        List<Integer> playerSalary = filterFunction(list, a -> a.getSalary());
        printSomething(playerSalary);
    }
}
