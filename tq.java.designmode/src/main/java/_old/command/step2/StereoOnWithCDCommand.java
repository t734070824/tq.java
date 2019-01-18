package _old.command.step2;

public class StereoOnWithCDCommand<T extends Stereo> implements Command{

	T t;
	
	public StereoOnWithCDCommand() {
	}
	
	@Override
	public void execute() {
		t.off();
	}

	
	public void setT(T t) {
		this.t = t;
	}
}
