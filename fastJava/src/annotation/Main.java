package annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Single{
    int value();
}
public class Main {
    @Single(10)
    public static void myMethod() throws NoSuchMethodException {
        Main obj = new Main();
        Method m = obj.getClass().getMethod("myMethod");
        Single single = m.getAnnotation(Single.class);
        System.out.println(single.value());
    }

    public static void main(String[] args) throws NoSuchMethodException {
        myMethod();
    }
}