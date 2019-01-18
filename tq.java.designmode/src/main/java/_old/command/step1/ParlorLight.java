package _old.command.step1;

public class ParlorLight implements Light{

	@Override
	public void on() {
		System.err.println("ParlorLight on");
	}

	@Override
	public void off() {
		System.err.println("ParlorLight off");
	}

}
