package polymophism1;

public class TVFactory {

	public static TV getTV(String id) {
		if(id.equals("lg")) {
			return  new LgTV();
		}else if (id.equals("samsung")) {
			return new SamsungTV();
		}
		return null;
	}
}
