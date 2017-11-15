package _threadlocal;

public class Work extends Thread {

	private QuerySvc querySvc;
	private String sql;

	public Work(QuerySvc querySvc, String sql) {
		this.querySvc = querySvc;
		this.sql = sql;

	}

	public void run() {
		querySvc.setSql(sql);
		querySvc.execute();
	}
	
	public static void main(String[] args) {
		QuerySvc qs = new QuerySvc();
		   for (int k=0; k<=10; k++){
		    String sql = "Select * from table where id =" + k;
		    new Work(qs,sql).start();
		}
	}

}