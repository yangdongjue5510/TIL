package Proxy;

public class Printer implements Printable {
	String name;

	public Printer() {
		heavyJob("Printer instance");
	}

	public Printer(String name) {
		this.name = name;
		heavyJob("Printer instance");
	}

	public String getPrinterName() {
		System.out.println("real : getName() ");
		return name;
	}

	public void setPrinterName(String string) {
		System.out.println("real: setName() ");
		this.name = name;
	}

	@Override
	public void print(String string) {
		System.out.println("==== " + this.name + " ====");
		System.out.println(string);
	}

	private void heavyJob(String message) {
		System.out.println(message);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("...");
		}
		System.out.println("complete");
	}
}
