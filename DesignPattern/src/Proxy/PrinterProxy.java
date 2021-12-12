package Proxy;

public class PrinterProxy implements Printable{
	private String name;
	private Printer real;
	public PrinterProxy(String string) {
		this.name = string;
	}
	@Override
	public String getPrinterName() {
		System.out.println("proxy : getName() ");
		return name;
	}

	@Override
	public void setPrinterName(String string) {
		if (real != null) {
			real.setPrinterName(name);
		}
		System.out.println("proxy : setName()");
		this.name = name;
	}

	@Override
	public void print(String string) {
		realize();
		real.print(string);
	}

	public synchronized void realize() {
		if (real == null) {
			real = new Printer(name);
		}
	}
}
