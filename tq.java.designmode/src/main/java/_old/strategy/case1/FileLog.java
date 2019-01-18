package _old.strategy.case1;

public class FileLog implements LogStrategy{

	@Override
	public void log(String msg) {
		System.err.println("insert to file");
	}

}
