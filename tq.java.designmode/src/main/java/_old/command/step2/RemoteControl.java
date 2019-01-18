package _old.command.step2;

public class RemoteControl {
	
	Command[] onCommands;
	Command[] offCommands;
	
	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		Command command = new NoCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = command;
			offCommands[i] = command;
		}
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
	
	
	public void onButtonWasPressed(int slot) {
		onCommands[slot].execute();
	}
	
	public void offButtonWasPressed(int slot) {
		offCommands[slot].execute();
	}
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n---------Remote Control---------\n");
		for (int i = 0; i < onCommands.length; i++) {
			sb.append("[slot:" + i).append(",")
			  .append("on:" + onCommands[i].getClass().getName()).append(",")
			  .append("off:" + offCommands[i].getClass().getName()).append("]");
		}
		return sb.toString();
	}
	

}
