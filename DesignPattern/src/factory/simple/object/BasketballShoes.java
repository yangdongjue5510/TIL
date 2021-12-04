package factory.simple.object;

public class BasketballShoes extends Shoe {
	@Override
	public void prepare() {
		System.out.println("prepare basketball shoes.");
	}

	@Override
	public void wrap() {
		System.out.println("wrapping basketball shoes");
	}

	@Override
	public void box() {
		System.out.println("boxing basketball shoes.");
	}
}
