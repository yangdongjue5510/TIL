package Adapter.adapter1;

public interface Adaptable {
    boolean supports(Object o);
    void handle(Object o);
}
