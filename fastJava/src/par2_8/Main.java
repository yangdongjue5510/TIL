package par2_8;

public class Main {
    public static void main(String[] args) {
        Human thomas = new Human(180, 56, "남성", "Thomas", 37);
        thomas.showInfo();
        Order order = new Order(202011020003L, 01023450001L, "서울시 강남구 역삼동 111-333", 20201102, 130258, 35000, 0003 );
        order.showInfo();
    }
}
