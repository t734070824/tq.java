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

	public static byte[] longToBytesShift(long l) {
		byte[] result = new byte[8];
		for (int i = 7; i >= 0; i--) {
			result[i] = (byte)(l & 0xFF);
			l >>= 8;
		}
		return result;
	}

	public static long bytesToLongShift(byte[] b) {
		long result = 0;
		for (int i = 0; i < 8; i++) {
			result <<= 8;
			result |= (b[i] & 0xFF);
		}
		return result;
	}

}
