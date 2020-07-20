package study;

public class InterfaceStudy1 implements Meter{

	@Override
	public void start() {
		
	}

	@Override
	public int stop(int distance) {
		
		return (distance*2);
	}

}
