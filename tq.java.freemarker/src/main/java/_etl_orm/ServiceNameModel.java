package _etl_orm;

public class ServiceNameModel {
	private String name;
	private String finalname;
	public ServiceNameModel(String name, String finalname) {
		this.name = name;
		this.finalname = finalname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFinalname() {
		return finalname;
	}
	public void setFinalname(String finalname) {
		this.finalname = finalname;
	}
	
	
}
