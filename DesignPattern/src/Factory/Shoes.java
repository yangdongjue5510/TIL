package Factory;

public abstract class Shoes {
    String modelName;
    Cushion cushion;
    Outsole outsole;
    Shoelace shoelace;
    Colors colors[];
    public abstract void prepare();

    public String getModelName(){
        return this.modelName;
    }
    public void setModelName(String str){
        this.modelName = str;
    }
    public void wrap(){
        System.out.println("wrapping...");
    }
    public void box(){
        System.out.println("boxing...");
    }
}
