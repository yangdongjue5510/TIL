package factory.simple;

import factory.simple.factory.ShoesFactory;
import factory.simple.object.Shoe;

public class Application {
	public static void main(String[] args) {
		ShoeStore store = new ShoeStore(new ShoesFactory());
		Shoe basketballShoe = store.orderShoes("basketball");
		store.orderShoes("football");
	}
	
}
