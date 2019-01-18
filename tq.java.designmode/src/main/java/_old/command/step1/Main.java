package _old.command.step1;

public class Main {
	public static void main(String[] args) {
		SimpleRemoteControl control = new SimpleRemoteControl();
		control.setCommand(new LightOnCommand(new ParlorLight()));
		control.buttonWasPressed();
	}
}
