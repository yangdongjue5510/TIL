package template_method.single_study;

public class MySQLConnection extends DataConnection{
	@Override
	public void findDriver() {
		System.out.println("MySQL 드라이버를 찾습니다.");
	}

	@Override
	public void connectDB() {
		System.out.println("MySQL과 연결합니다.");
	}
}
