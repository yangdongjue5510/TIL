package factory.group;

public class BackEndDeveloper extends Developer{

	@Override
	public void learnLanguage() {
		this.language = Language.JAVA;
		System.out.println("자바 언어를 배웠습니다!");
	}

	@Override
	public void learnFramework() {
		this.framework = Framework.SPRING;
		System.out.println("스프링을 배웠습니다.");
	}
}
