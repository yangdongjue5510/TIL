package factory.factory_method.object;

public class NikeBasketballShoe extends Shoe{
	public NikeBasketballShoe() {
		this.cushion = "nike cushion";
		this.modelName = "nike basketball";
		this.signaturePlayer = "yang";
		this.shoeItem.add("nike sticker");
	}

	@Override
	public void wrap() {
		System.out.println("wrap nike basketball shoes");
	}

	@Override
	public void box() {
		System.out.println("box nike basketball shoes");
	}
}
