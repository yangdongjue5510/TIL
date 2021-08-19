package Factory;

import java.util.ArrayList;

public abstract class Shoes {
    String modelName;
    String cushion;
    String signaturePlayer;
    ArrayList<String> shoeItem = new ArrayList<>();
    public void prepare(){
        System.out.println("ready for "+ modelName);
        System.out.println("ready for "+ cushion);
        System.out.println("this shoes are for "+ signaturePlayer);
        for (String item : shoeItem){
            System.out.println("add "+item);
        }
    }
    public String getModelName(){
        return this.modelName;
    }
    public abstract void wrap();
    public abstract void box();
}
