package factory.group;

public class BootCamp {

	public Developer teachDeveloper(DevelopType type) {
		Developer developer = createDeveloper(type);
		developer.learnLanguage();
		developer.learnFramework();
		return developer;
	}

	private Developer createDeveloper(DevelopType type) {
		Developer developer = null;
		switch (type) {
			case BACKEND:
				developer = new BackEndDeveloper();
				break;
			case FRONTEND:
				developer = new FrontEndDeveloper();
				break;
		}
		return developer;
	}
}
