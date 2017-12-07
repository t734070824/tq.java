package _ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket = new Socket("127.0.0.1", 8080);
		
		boolean autoflush = true;
		PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out.println("GET /index.jsp HTTP/1.1");
		out.println("Host: localhost:8080");
		out.println("Connection: close");
		out.println();
		
		
		boolean loop = true;
		StringBuffer buffer = new StringBuffer(8096);
		while(loop) {
			if(in.ready()) {
				int i = 0;
				while(i != -1) {
					i = in.read();
					buffer.append((char) i);
				}
				loop = false;
			}
			Thread.sleep(50);
		}
		
		System.err.println(buffer.toString());
		socket.close();
	}

}
