package factory.factory_method.object;

import java.util.ArrayList;

public abstract class Shoe {
	String modelName;
	String cushion;
	String signaturePlayer;
	ArrayList<String> shoeItem = new ArrayList<>();

	public void prepare() {
		System.out.println(modelName);
		System.out.println(cushion);
		System.out.println(signaturePlayer);
		shoeItem.stream().forEach(item -> System.out.println(item));
	}

	public String getModelName() {
		return this.modelName;
	}

	public abstract void wrap();
	public abstract void box();
}