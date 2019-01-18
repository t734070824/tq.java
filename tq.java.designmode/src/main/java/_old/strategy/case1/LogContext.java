package _old.strategy.case1;

public class LogContext {

	
	public void log(String msg){
		LogStrategy log = new DBLog();
		try {
			log.log(msg);
		} catch (Exception e) {
			log = new FileLog();
			log.log(msg);
		}
	}
}
