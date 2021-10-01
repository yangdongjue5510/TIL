package Singleton;

public class Singleton {
    private static Singleton uniqueObject;
    private Singleton(){}
    public Singleton getInstance(){
        if(uniqueObject == null){
            uniqueObject =new Singleton();
        }
        return uniqueObject;
    }
}
