package _old.command.step2;

public class Main {
	public static void main(String[] args) {
		RemoteControl control = new RemoteControl();
		ParlorStereo parlorStereo = new ParlorStereo();
		StereoOnWithCDCommand<ParlorStereo> stereoOn = new StereoOnWithCDCommand<ParlorStereo>();
		StereoOffWithCDCommand<ParlorStereo> stereOff = new StereoOffWithCDCommand<>();
		stereOff.setT(parlorStereo);
		stereoOn.setT(parlorStereo);
		control.setCommand(1, stereoOn, stereOff);
		System.err.println(control);
		control.onButtonWasPressed(1);
		
	}
}
