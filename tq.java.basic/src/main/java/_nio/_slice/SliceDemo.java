package _nio._slice;

import java.nio.ByteBuffer;

public class SliceDemo {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i=0; i<buffer.capacity(); ++i) {
            buffer.put( (byte)i );
        }

        buffer.position( 3 );
        buffer.limit( 7 );
        ByteBuffer slice = buffer.slice();

    }
}
