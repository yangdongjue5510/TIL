package template_method.group_study;

public class YoungStudent extends Student{
	@Override
	public void afternoonLecture() {
		System.out.println("저학년은 수업 계획이 없습니다!");
	}

	@Override
	public void goHome() {
		System.out.println("선생님과 함께 집에 갑니다!");
	}

	@Override
	public boolean checkAge() {
		return false;
	}
}
