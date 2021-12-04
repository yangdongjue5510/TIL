package factory.factory_method.factory;

import factory.factory_method.object.NikeBasketballShoe;
import factory.factory_method.object.NikeFootballShoe;
import factory.factory_method.object.Shoe;

public class NikeShoeFactory extends ShoeFactory{
	@Override
	protected Shoe createShoe(String type) {
		if (type.equals("basketball")) {
			return  new NikeBasketballShoe();
		} else if (type.equals("football")) {
			return new NikeFootballShoe();
		}
		return null;
	}
}
