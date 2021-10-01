package Singleton;

public class Singleton2 {
    private Singleton2(){}
    public static class LazyHolder{
       private static final Singleton2 uniqueInstance = new Singleton2();
    }
    public static Singleton2 getInstance(){return LazyHolder.uniqueInstance;}
}
