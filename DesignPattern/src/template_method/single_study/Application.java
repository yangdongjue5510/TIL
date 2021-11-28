package template_method.single_study;

public class Application {
	public static void main(String[] args) {
		DataConnection dataConnection = new MySQLConnection();
		dataConnection.process();

		dataConnection = new H2Connection();
		dataConnection.process();
	}
}
