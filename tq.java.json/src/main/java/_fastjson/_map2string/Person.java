package _fastjson._map2string;

public class Person {

	private int id;
	
	private String name;
	
	private int sex;
	
	private Adress adress;

    public Person(int id, String name, int sex, Adress adress) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
