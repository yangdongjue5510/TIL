package factory.simple.factory;

import factory.simple.object.BasketballShoes;
import factory.simple.object.FootballShoes;
import factory.simple.object.Shoe;

public class ShoesFactory {
	public Shoe createShoes (String type) {
		Shoe shoe = null;
		if (type.equals("basketball")) {
			shoe = new BasketballShoes();
		} else if (type.equals("football")) {
			shoe = new FootballShoes();
		}
		return shoe;
	}
}
