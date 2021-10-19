package polymophism1;

public class SamsungTV implements TV{
	public SamsungTV() {
		System.out.println("Samsung TV..");
	}
	
	public void powerOff() {
		System.out.println("Samsung power off");
	}
	
	public void powerOn() {
		System.out.println("Samsung power on");
	}
	
	public void volumeUp() {
		System.out.println("Samsung volume up.");
	}
	public void volumeDown() {
		System.out.println("Samsung volume down.");
	}

}
