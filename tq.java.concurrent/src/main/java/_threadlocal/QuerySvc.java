package _threadlocal;

public class QuerySvc {
	private String sql;

	private static ThreadLocal<String> sqlHolder = new ThreadLocal<String>();

	public QuerySvc() {

	}

	public void execute() {
		System.out.println("Thread " + Thread.currentThread().getId() + " Sql  is " + sql);
		System.out.println("Thread " + Thread.currentThread().getId() + " Thread Local variable Sql is " + sqlHolder.get());
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
		sqlHolder.set(sql);

	}

}