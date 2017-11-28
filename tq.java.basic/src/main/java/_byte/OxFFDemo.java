package _byte;

import java.util.Arrays;

public class OxFFDemo {
	
	public static void main(String[] args) {
		byte b = -1;
		System.err.println(Long.toBinaryString(b));
		System.err.println(Integer.toBinaryString(b));
		System.err.println(Byte.toString(b));
		
		System.err.println(Integer.parseInt("00000000000000000000000011111111", 2));
		
		System.err.println((int)b);
		System.err.println(b & 0xFF);
		
		BytesToLong to = new BytesToLong();
		System.err.println(Arrays.toString(to.longToBytes(-2147483649L)));
		byte[] bs = new byte[] {-1, -1, -1, -1, 127, -1, -1, -1};
		System.err.println(makeLong(bs));
		System.err.println(makeLongWithOutOxFF(bs));
		
		System.err.println(Long.toBinaryString((long)-127));
		
		byte bb = -3;
		System.err.println(bb & 0xFF);
		
		
		System.err.println(Integer.parseInt("11111101", 2));
		
		System.err.println((long)(-1 & 0xFF));
		System.err.println((long)-1 & 0xFF);
		
		System.err.println(-1 & 0xFF);
		
		System.err.println((byte)300);
		
		System.err.println(44 & 0xFF);
		BytesToInt toInt = new BytesToInt();
		System.err.println(Arrays.toString(toInt.IntToBytes(255)));
		System.err.println(Arrays.toString(toInt.IntToBytes(254)));
		
		System.err.println(Integer.parseUnsignedInt("11111111111111111111111111111111", 2));
	}
	
	
    static long makeLong(byte b7, byte b6, byte b5, byte b4,
            byte b3, byte b2, byte b1, byte b0)
		{
		return ((((long)b7       ) << 56) |
		(((long)b6 & 0xff) << 48) |
		(((long)b5 & 0xff) << 40) |
		(((long)b4 & 0xff) << 32) |
		(((long)b3 & 0xff) << 24) |
		(((long)b2 & 0xff) << 16) |
		(((long)b1 & 0xff) <<  8) |
		(((long)b0 & 0xff)      ));
		}
    
    static long makeLong(byte[] bs) {
    	return ((((long)bs[0]       ) << 56) |
    			(((long)bs[1] & 0xff) << 48) |
    			(((long)bs[2] & 0xff) << 40) |
    			(((long)bs[3] & 0xff) << 32) |
    			(((long)bs[4] & 0xff) << 24) |
    			(((long)bs[5] & 0xff) << 16) |
    			(((long)bs[6] & 0xff) <<  8) |
    			(((long)bs[7] & 0xff)      ));
    }
    
    static long makeLongWithOutOxFF(byte[] bs) {
    	return ((((long)bs[0]       ) << 56) |
    			(((long)bs[1] ) << 48) |
    			(((long)bs[2] ) << 40) |
    			(((long)bs[3] ) << 32) |
    			(((long)bs[4] ) << 24) |
    			(((long)bs[5] ) << 16) |
    			(((long)bs[6] ) <<  8) |
    			(((long)bs[7] )      ));
    }

}
