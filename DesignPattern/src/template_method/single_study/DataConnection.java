package template_method.single_study;

public abstract class DataConnection {
	public void process() {
		findDriver();
		login();
		connectDB();
	}

	public abstract void findDriver();
	public abstract void connectDB();

	public void login() {
		System.out.println("로그인을 실행합니다...");
	}
}
