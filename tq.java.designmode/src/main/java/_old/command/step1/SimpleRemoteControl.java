package _old.command.step1;

public class SimpleRemoteControl {

	Command command;
	
	public SimpleRemoteControl() {
	}

	
	public void buttonWasPressed() {
		command.execute();
	}
	
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	
}
