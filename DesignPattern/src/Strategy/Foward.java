package Strategy;

public class Foward extends Player{
    public Foward(){
        dribbleBehavior = new PowerDribble();
        shootBehavior = new DunkShoot();
    }

    @Override
    public void display() {
        System.out.println("Here comes new Forward...!");
    }
}
