package factory.simple;

import factory.simple.factory.ShoesFactory;
import factory.simple.object.Shoe;

public class ShoeStore {
	ShoesFactory factory;

	public ShoeStore(ShoesFactory factory) {
		this.factory = factory;
	}

	public Shoe orderShoes(String type) {
		Shoe shoe;
		shoe = factory.createShoes(type);

		shoe.prepare();
		shoe.wrap();
		shoe.box();
		return shoe;
	}
}
