package _old.strategy.step3;

/**
 * 1.把变化的部分取出并封装起来,以便以后可以轻易的修改变动或扩充此部分,和其他稳定的代码有所区分.
 * @author tangqing
 *
 */
public abstract class Duck {
	
	public FlyBehavior fly;
	
	public QuackBehavior quack;
	
	public abstract void display();
	
	public void swim() {
		System.err.println("swim");
	}
	
	public void performFly(){
		fly.fly();
	}
	
	public void performQuack(){
		quack.quack();
	}

	public void setFly(FlyBehavior fly) {
		this.fly = fly;
	}

	public void setQuack(QuackBehavior quack) {
		this.quack = quack;
	}
}

