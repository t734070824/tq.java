package _fastjson._map2string;

public class Adress {
	
	private String name;
	
	private String address;
	
	private Integer num;
	
	private int numInt;
	
	

	public Adress(String name, String address, Integer num) {
		super();
		this.name = name;
		this.address = address;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public int getNumInt() {
		return numInt;
	}

	public void setNumInt(int numInt) {
		this.numInt = numInt;
	}
	
	

}
