package _clone;


public class TestCopy {
	public static void main(String[] args) {
		int ballNum = 7;
		Balloon[] balls = new Balloon[ballNum];
		Balloon[] balls2 = new Balloon[balls.length];
		for (int i = 0; i < balls.length; i++) {
			balls[i] = new Balloon(i, Color.values()[i]);
		}
		for (int i = 0; i < balls.length; i++) {
			balls2[i] = new Balloon(i, Color.values()[i]);
		}
		balls[6].setColor(Color.B);
		for (int i = 0; i < balls2.length; i++) {
			System.out.println(balls2[i]);
		}
	}
}

class Balloon {
	
	
	private int id;
	private Color color;
	
	public Balloon(int id, Color color) {
		this.id= id;
		this.color = color;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return  id+"  " + color;
	}
}

enum Color {
    R,O,Y,G,I,B,V;
}