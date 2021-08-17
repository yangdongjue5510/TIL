package JavaPrac;

public interface PlayerLevel {

    public abstract void run();
    public abstract void jump();
    public abstract void turn();
    public abstract void showLevelMessage();
    default void go(int count){
        this.run();
        for (int i = 0; i<count; i++){
            this.jump();
        }
        this.turn();
    }
}
