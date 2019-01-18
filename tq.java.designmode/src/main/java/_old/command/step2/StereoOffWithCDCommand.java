package _old.command.step2;

public class StereoOffWithCDCommand<T extends Stereo> implements Command{

	T t;
	
	public StereoOffWithCDCommand() {
	}
	
	@Override
	public void execute() {
		t.on();
		t.setCD("TQ");
		t.setDVD("AH");
	}

	public void setT(T t) {
		this.t = t;
	}

}
