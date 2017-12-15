package _fastjson._map2string;

public class Adress {
	
	private String addressName;
	
	private String addressStr;
	
	private Integer num;

    public Adress(String addressName, String addressStr, Integer num) {
        this.addressName = addressName;
        this.addressStr = addressStr;
        this.num = num;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
