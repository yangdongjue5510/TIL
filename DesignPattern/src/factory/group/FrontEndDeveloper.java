package factory.group;

public class FrontEndDeveloper extends Developer {
	@Override
	public void learnLanguage() {
		this.language = Language.JS;
		System.out.println("JS를 배웠습니다.");
	}

	@Override
	public void learnFramework() {
		this.framework = Framework.REACT;
		System.out.println("리액트를 배웠습니다.");
	}
}
