package _abstract;

public class AbsPrintImpl extends AbsPrint{
	
	private int i = 10;

	@Override
	public void print() {
		System.err.println(this.i);
	}
}
