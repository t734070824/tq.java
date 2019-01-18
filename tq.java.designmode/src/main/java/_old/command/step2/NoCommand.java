package _old.command.step2;

public class NoCommand implements Command {

	@Override
	public void execute() {
		System.err.println("nothing");
	}

}
