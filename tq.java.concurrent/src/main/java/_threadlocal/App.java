package _threadlocal;

public class App {
//	public static void main(String[] args) {
//	    ProductService productService = new ProductServiceImpl();
//	    productService.updateProductPrice(1, 3000);
//	}

	
	public static void main(String[] args) {
	    for (int i = 0; i < 10; i++) {
	        ProductService productService = new ProductServiceImpl();
	        ClientThread thread = new ClientThread(productService);
	        thread.start();
	    }
	}
}
