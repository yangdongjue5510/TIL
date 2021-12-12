package Proxy;

public class Main {
	public static void main(String[] args) {
		Printable p = new PrinterProxy("YANG");
		System.out.println("현재 이름 : " + p.getPrinterName());
		p.setPrinterName("DONG");
		p.print("printer test");

		p.setPrinterName("JUE");
		p.print("hello");
	}
}
