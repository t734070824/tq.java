package _calss_init_order;

public class ContainThis {

    private int i = 3;

    private int m = 0;


    public ContainThis(int m) {
        this.m = m;
        System.err.println("ContainThis");
    }

    public int getI() {
        return i;
    }

    public int getM() {
        return m;
    }

    ThisDemo demo = new ThisDemo(this);


    public static void main(String[] args) {
        ContainThis containThis = new ContainThis(3);
        System.err.println(containThis.getM());
    }
}
