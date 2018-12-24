package _nio._buffer;

import java.nio.ByteBuffer;

public class GetAndPutDemo {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        byteBuffer.put((byte) 1);

        /**
         * byteBuffer.flip();
         * 类似于
         */
        byteBuffer.limit(byteBuffer.position());
        byteBuffer.position(0);


        byte b = byteBuffer.get();
        System.err.println(b);


    }


}
