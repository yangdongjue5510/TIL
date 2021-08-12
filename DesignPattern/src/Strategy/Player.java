package Strategy;

public abstract class Player {
    DribbleBehavior dribbleBehavior;
    ShootBehavior shootBehavior;
    public Player(){
    }
    public abstract void display();

    public void setShootBehavior(ShootBehavior sb){ shootBehavior = sb; }
    public void setDribbleBehavior(DribbleBehavior db){ dribbleBehavior = db; }
    public void performDribble(){
        dribbleBehavior.dribble();
    }
    public void performShoot(){
        shootBehavior.shoot();
    }
}