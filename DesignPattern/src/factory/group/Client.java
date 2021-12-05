package factory.group;

public class Client {
	public static void main(String[] args) {
		BootCamp fastCampus = new BootCamp();

		Developer yang = fastCampus.teachDeveloper(DevelopType.BACKEND);
		Developer kim = fastCampus.teachDeveloper(DevelopType.FRONTEND);
	}
}
