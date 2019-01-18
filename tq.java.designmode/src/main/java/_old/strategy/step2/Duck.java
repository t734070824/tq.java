package _old.strategy.step2;


/**
 * 将飞行和叫方法从Duck中分离,形成两个接口
 * 	1.这样会使代码量增加,
 * 	2.当要有多个Duck的飞行行为要改变的时候,要修改大量大代码
 * @author tangqing
 *
 */
public class Duck {
	public void quack(){
		System.err.println("quack");
	}
	
	public void swim() {
		System.err.println("swim");
	}
	
	
}
