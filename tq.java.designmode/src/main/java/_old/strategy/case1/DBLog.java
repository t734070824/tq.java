package _old.strategy.case1;

public class DBLog implements LogStrategy{

	@Override
	public void log(String msg) {
		if(msg != null && msg.length() > 5){
			System.err.println(5/0);
		}
		System.err.println("insert to DB");
	}

}
