package factory.factory_method.object;

public class NikeFootballShoe extends Shoe{
	public NikeFootballShoe() {
		this.cushion = "nike cushion";
		this.modelName = "nike football";
		this.signaturePlayer = "yang";
		this.shoeItem.add("nike sticker");
	}

	@Override
	public void wrap() {
		System.out.println("wrap nikefootball shoes");
	}

	@Override
	public void box() {
		System.out.println("box nike football shoes");
	}
}
