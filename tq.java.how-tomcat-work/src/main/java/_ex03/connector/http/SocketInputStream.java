package _ex03.connector.http;

import java.io.IOException;
import java.io.InputStream;

public class SocketInputStream extends InputStream{

	private InputStream inputStream;
	
	private int size;
	
	public SocketInputStream(InputStream inputStream, int size) {
		
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
