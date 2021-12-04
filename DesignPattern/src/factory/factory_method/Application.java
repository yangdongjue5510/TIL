package factory.factory_method;

import factory.factory_method.factory.NikeShoeFactory;

public class Application {
	public static void main(String[] args) {
		NikeShoeFactory nikeFactory = new NikeShoeFactory();
		nikeFactory.orderShoes("football");
		nikeFactory.orderShoes("basketball");
	}
}
