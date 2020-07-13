package com.gao.nio;

import java.nio.ByteBuffer;

/**
 * 只读Buffer，我们可以随时将一个普通的Buffer调用asReadOnlyBuffer方法返回一个只读Buffer
 * 但不能将一个只读Buffer转换为读写Buffer
 */
public class NioTest7 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.getClass());
        for(int i=0;i<byteBuffer.capacity();i++){
            byteBuffer.put((byte)i);
        }
        ByteBuffer byteBufferR = byteBuffer.asReadOnlyBuffer();
        System.out.println(byteBufferR.getClass());
        byteBufferR.position(0);
        //byteBufferR.put((byte)2);

    }
}
