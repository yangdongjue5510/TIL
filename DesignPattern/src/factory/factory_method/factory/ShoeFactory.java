package factory.factory_method.factory;

import factory.factory_method.object.Shoe;

public abstract class ShoeFactory {
	public Shoe orderShoes(String type) {
		Shoe shoe;
		shoe = createShoe(type);

		shoe.prepare();
		shoe.wrap();
		shoe.box();
		return shoe;
	}

	protected abstract Shoe createShoe(String type);
}
