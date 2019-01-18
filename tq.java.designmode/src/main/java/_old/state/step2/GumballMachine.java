package _old.state.step2;

public class GumballMachine {
	
	final static int SOLD_OUT = 0;
	
	final static int NO_QUARTER = 1;
	
	final static int HAS_QUARTER = 2;
	
	final static int SOLD = 3;
	
	int state = SOLD_OUT;
	
	int count = 0;
	
	
	public GumballMachine(int count) {
		this.count = count;
		if(count > 0){
			state = NO_QUARTER;
		}
	}
	
	
	public void insertQuarter() {
		if(state == HAS_QUARTER){
			System.err.println("can't insert another quarter");
		} else if(state == NO_QUARTER){
			state = HAS_QUARTER;
			System.err.println("insert quarter success");
		} else if(state == SOLD_OUT){
			System.err.println("sold is out");
		} else if(state ==  SOLD){
			System.err.println("wait!! we are already give you a gumball");
		}
	}
	
	public void ejectQuarter() {
		if(state == HAS_QUARTER){
			System.err.println("quarter return");
			state = NO_QUARTER;
		} else if(state == NO_QUARTER){
			System.err.println("no quarter");
		} else if(state == SOLD_OUT){
			System.err.println("you can't eject");
		} else if(state ==  SOLD){
			System.err.println("sorry, you already turned  the crank");
		}
	}
	
	public void turnCrank() {
		if(state == HAS_QUARTER){
			System.err.println("you turned......");
			state = SOLD;
			dispense();
		} else if(state == NO_QUARTER){
			System.err.println("you need to pay first");
		} else if(state == SOLD_OUT){
			System.err.println("out of gumballs");
		} else if(state ==  SOLD){
			System.err.println("only one");
		}
	}


	public void dispense() {
		if(state == HAS_QUARTER){
			System.err.println("no gumball dispense");
		} else if(state == NO_QUARTER){
			System.err.println("you need to pay first");
		} else if(state == SOLD_OUT){
			System.err.println("no gumball dispense");
		} else if(state ==  SOLD){
			System.err.println("a gumball comes rolling out the slot");
			count = count - 1;
			if(count == 0){
				System.err.println("out of gumballs");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		}
	}
	
	@Override
	public String toString() {
		return "count--"+count + "  state--" + state;
	}

}
