package _byte;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class BytesToLong {
	
	public static void main(String[] args) {
		BytesToLong to = new BytesToLong();
		System.err.println(Arrays.toString(to.longToBytes(22)));
		
		
		System.err.println(to.bytesToLong(new byte[] {0, 0, 0, 0, 0, 0, 0, 22, 0}));
		
		
		
	}

	public byte[] longToBytes(long x) {
	    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
	    buffer.putLong(x);
	    return buffer.array();
	}
	
	public long bytesToLong(byte[] bytes) {
	    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
	    buffer.put(bytes);
	    buffer.flip();//need flip 
	    return buffer.getLong();
	}

}
