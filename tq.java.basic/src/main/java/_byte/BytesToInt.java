package _byte;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class BytesToInt {
	
	public static void main(String[] args) {
		BytesToInt to = new BytesToInt();
		System.err.println(Arrays.toString(to.IntToBytes(Integer.MAX_VALUE)));
		System.err.println("Integer.toBinaryString(220)-->"+Integer.toBinaryString(220));
		
		System.err.println(to.bytesToInt(new byte[] {0, 0, 0, -36}));
		
		
		
		System.err.println(Arrays.toString(to.IntToBytes(-1)));
		
		System.err.println("(byte)-1 -->" +(byte)-1);
		
		
		System.err.println(Integer.toBinaryString(-1));
		
		System.err.println(to.bytesToInt(new byte[] {1, 1, 1, 1}));
		
		
		System.err.println(parseInt("1111111111111111111111111111111", 2));
		System.err.println(Long.parseLong("10000000000000000000000000000001", 2));
		
		System.err.println(integerfrmbinary("10000000000000000000000000000001"));
		
		System.err.println(0x7fffffff);
		
		System.err.println("Integer.toBinaryString(-Integer.MAX_VALUE)-->" +Integer.toBinaryString(-Integer.MAX_VALUE));
		
		
		
		
		System.err.println(Integer.toBinaryString(-2147483647));
		
		
		System.err.println(Long.toBinaryString(2147483649L));
		System.err.println(Long.toBinaryString(Long.MAX_VALUE));
		
		
		System.err.println("parseUnsignedInt-->"+parseUnsignedInt("10000000000000000000000000000001", 2));
		System.err.println("parseUnsignedLong-->"+Long.parseUnsignedLong("10000000000000000000000000000001", 2));
		
		
		System.err.println("Long.toBinaryString(0xffff_ffff_0000_0000L)-->" + Long.toBinaryString(0xffff_ffff_0000_0000L));
		
		System.err.println("Long.toBinaryString(0xff)" + Long.toBinaryString(0xff));
		
		
		
		
	}

	public byte[] IntToBytes(int x) {
	    ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
	    buffer.putInt(x);
	    return buffer.array();
	}
	
	public long bytesToInt(byte[] bytes) {
	    ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
	    buffer.put(bytes);
	    buffer.flip();//need flip 
	    return buffer.getInt();
	}
	
	
	public static int integerfrmbinary(String str){
	    double j=0;
	    for(int i=0;i<str.length();i++){
	        if(str.charAt(i)== '1'){
	         j=j+ Math.pow(2,str.length()-1-i);
	     }

	    }
	    return (int) j;
	}
	
    public static int parseUnsignedInt(String s, int radix)
            throws NumberFormatException {
    if (s == null)  {
        throw new NumberFormatException("null");
    }

    int len = s.length();
    if (len > 0) {
        char firstChar = s.charAt(0);
        if (firstChar == '-') {
            throw new
                NumberFormatException(String.format("Illegal leading minus sign " +
                                                   "on unsigned string %s.", s));
        } else {
            if (len <= 5 || // Integer.MAX_VALUE in Character.MAX_RADIX is 6 digits
                (radix == 10 && len <= 9) ) { // Integer.MAX_VALUE in base 10 is 10 digits
                return parseInt(s, radix);
            } else {
                long ell = Long.parseLong(s, radix);
                if ((ell & 0xffff_ffff_0000_0000L) == 0) {
                    return (int) ell;
                } else {
                    throw new
                        NumberFormatException(String.format("String value %s exceeds " +
                                                            "range of unsigned int.", s));
                }
            }
        }
    } else {
        throw new NumberFormatException("For input string: \"" + s + "\"");
    }
    
    
    
    
    
}
    
    public static int parseInt(String s, int radix)
            throws NumberFormatException
{
    /*
     * WARNING: This method may be invoked early during VM initialization
     * before IntegerCache is initialized. Care must be taken to not use
     * the valueOf method.
     */

    if (s == null) {
        throw new NumberFormatException("null");
    }

    if (radix < Character.MIN_RADIX) {
        throw new NumberFormatException("radix " + radix +
                                        " less than Character.MIN_RADIX");
    }

    if (radix > Character.MAX_RADIX) {
        throw new NumberFormatException("radix " + radix +
                                        " greater than Character.MAX_RADIX");
    }

    int result = 0;
    boolean negative = false;
    int i = 0, len = s.length();
    int limit = -Integer.MAX_VALUE;
    int multmin;
    int digit;

    if (len > 0) {
        char firstChar = s.charAt(0);
        if (firstChar < '0') { // Possible leading "+" or "-"
            if (firstChar == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;
            } else if (firstChar != '+')
                throw new NumberFormatException("For input string: \"" + s + "\"");

            if (len == 1) // Cannot have lone "+" or "-"
                throw new NumberFormatException("For input string: \"" + s + "\"");
            i++;
        }
        multmin = limit / radix;
        while (i < len) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            digit = Character.digit(s.charAt(i++),radix);
            if (digit < 0) {
                throw new NumberFormatException("For input string: \"" + s + "\"");
            }
            if (result < multmin) {
                throw new NumberFormatException("For input string: \"" + s + "\"");
            }
            result *= radix;
            if (result < limit + digit) {
                throw new NumberFormatException("For input string: \"" + s + "\"");
            }
            result -= digit;
        }
    } else {
        throw new NumberFormatException("For input string: \"" + s + "\"");
    }
    return negative ? result : -result;
}

    
    
}
