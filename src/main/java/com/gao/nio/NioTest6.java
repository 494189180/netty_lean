package com.gao.nio;

import java.nio.ByteBuffer;

public class NioTest6 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for(int i=0;i<byteBuffer.capacity();i++){
            byteBuffer.put((byte)i);
        }
        byteBuffer.position(2);
        byteBuffer.limit();

        ByteBuffer sliceBuffer = byteBuffer.slice();
        for(int i=0;i<sliceBuffer.capacity();i++){
            byte b = sliceBuffer.get();
            b *= 2;
            sliceBuffer.put(i,b);
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        System.out.println("------------------------");
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }


    }
}
