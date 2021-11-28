package template_method.group_study;

public class Application {
	public static void main(String[] args) {
		Student yangdongjue = new YoungStudent();
		Student junginwoo = new SeniorStudent();

		yangdongjue.listenSchool();
		junginwoo.listenSchool();
	}
}
