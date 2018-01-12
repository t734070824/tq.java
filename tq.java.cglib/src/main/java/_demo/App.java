package _demo;

public class App {

	public static void main(String[] args) {
		BookCglib cglib = new BookCglib();
		BookImpl impl = (BookImpl)cglib.getInstance(new BookImpl());
		impl.up(2);
	}
}
