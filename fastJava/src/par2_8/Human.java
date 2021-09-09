package par2_8;


public class Human {
    private int height;
    private int wieght;
    private String gender;
    private String name;
    private int age;
    public Human(int height, int wieght, String gender, String name, int age){
        this.height = height;
        this.wieght = wieght;
        this.gender = gender;
        this.name = name;
        this.age = age;
    }
    public void showInfo(){
        System.out.printf("키가 %d이고 몸무게가 %d키로인 %s이 있다. 이름은 %s이고 나이는 %d세이다.",getHeight(), getWieght(), getGender(), getName(), getAge());
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWieght() {
        return wieght;
    }

    public void setWieght(int wieght) {
        this.wieght = wieght;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
