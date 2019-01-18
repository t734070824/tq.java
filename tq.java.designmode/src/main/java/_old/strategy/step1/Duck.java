package _old.strategy.step1;

/**
 * 这种设计方式 
 * 	1.如果此时想让鸭子可以飞,似乎直接在Duck类中添加一个fly方法即可,但是并不是所有的鸭子都会飞...........
 * 	2.可以通过覆盖父类的方法可以实现不同鸭子的特色行为,但是当要新添加一个新的鸭子类型的时候,又要覆盖父类的方法....
 * @author tangqing
 *
 */
public abstract class Duck {

	public void quack(){
		System.err.println("quack");
	}
	
	public void swim() {
		System.err.println("swim");
	}
	
	
	public abstract void display();
}
