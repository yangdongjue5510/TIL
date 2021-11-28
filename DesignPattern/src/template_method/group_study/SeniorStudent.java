package template_method.group_study;

public class SeniorStudent extends Student{

	@Override
	public void afternoonLecture() {
		System.out.println("고학년들은 오후수업을 진행합니다.");
	}

	@Override
	public void goHome() {
		System.out.println("혼자서 집으로 돌아갑니다.");
	}

	@Override
	public boolean checkAge() {
		return true;
	}
}
