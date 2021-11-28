package template_method.single_study;

public class H2Connection extends DataConnection{
	@Override
	public void findDriver() {
		System.out.println("H2 드라이버를 찾습니다.");
	}

	@Override
	public void connectDB() {
		System.out.println("H2 드라이버를 연결합니다.");
	}
}
