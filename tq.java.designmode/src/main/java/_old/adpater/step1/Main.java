package _old.adpater.step1;

public class Main {
	public static void main(String[] args) {
		Turkey turkey = new WildTurkey();
		TurkeyAdapter<Turkey> adapter = new TurkeyAdapter<Turkey>(turkey);
		adapter.fly();
		adapter.quack();
	}
}
