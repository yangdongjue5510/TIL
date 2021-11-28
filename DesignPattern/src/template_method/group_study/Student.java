package template_method.group_study;

public abstract class Student {

	public void listenSchool() {
		morningLecture();
		if (checkAge()) {
			afternoonLecture(); //고학년만
		}
		goHome();
	}

	protected final void morningLecture() {
		System.out.println("오전 수업을 수강합니다!!!");
	}

	protected abstract void afternoonLecture();

	protected abstract void goHome();

	protected abstract boolean checkAge();
}
