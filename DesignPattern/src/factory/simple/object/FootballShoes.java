package factory.simple.object;

public class FootballShoes extends Shoe {
	@Override
	public void prepare() {
		System.out.println("prepare football shoes.");
	}

	@Override
	public void wrap() {
		System.out.println("wrapping football shoes");
	}

	@Override
	public void box() {
		System.out.println("boxing football shoes.");
	}
}
