package par2_8;

public class Order {
    private long orderNum;
    private long phoneNum;
    private String address;
    private int date;
    private int time;
    private int price;
    private int menuNum;
    public Order(long orderNum, long phoneNum, String address, int date, int time, int price, int menuNum) {
        this.orderNum = orderNum;
        this.phoneNum = phoneNum;
        this.address = address;
        this.date = date;
        this.time = time;
        this.price = price;
        this.menuNum = menuNum;
    }

    public Order(){}

    public void showInfo(){
        System.out.printf("주문 접수 번호 : %d\n" +
                "주문 핸드폰 번호 : %d\n" +
                "주문 집 주소 : %s\n" +
                "주문 날짜 : %d\n" +
                "주문 시간 : %d\n" +
                "주문 가격 : %d\n" +
                "메뉴 번호 : %d", orderNum, phoneNum,address,date,time,price,menuNum);
    }
}
