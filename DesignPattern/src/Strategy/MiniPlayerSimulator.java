package Strategy;

public class MiniPlayerSimulator {
    public static void main(String[] args){
        Player curry = new Guard();
        curry.display();
        curry.performDribble();
        //dynamically setter
        curry.setDribbleBehavior(new HegiDribble());
        curry.performDribble();
        curry.performShoot();

        Player james = new Foward();
        james.display();
        james.performDribble();
        james.performShoot();
    }
}
