package Strategy;

public class Guard extends Player{
    public Guard(){
        dribbleBehavior = new CrossOverDribble();
        shootBehavior = new ThreePointShoot();
    }
    @Override
    public void display() {
        System.out.println("Here comes new Guard!");
    }
}
