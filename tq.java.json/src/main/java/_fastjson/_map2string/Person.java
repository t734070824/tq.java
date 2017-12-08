package _fastjson._map2string;

public class Person {
	
	private String name;
	
	private int sex;
	
	private Adress adress;

	public Person(String name, int sex, Adress adress) {
		super();
		this.name = name;
		this.sex = sex;
		this.adress = adress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

}
