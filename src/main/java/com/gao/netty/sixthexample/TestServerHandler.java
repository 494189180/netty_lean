package com.gao.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.myMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.myMessage msg) throws Exception {
        DataInfo.myMessage.DataType dataType = msg.getDataType();
        System.out.println(dataType);
        switch (dataType) {
            case PersonType:
                System.out.println("PersonType:");
                DataInfo.Person person = msg.getPerson();
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                break;
            case DogType:
                System.out.println("DogType:");
                DataInfo.Dog dog = msg.getDog();
                System.out.println(dog.getName());
                System.out.println(dog.getAge());
                break;
            case CatType:
                System.out.println("CatType:");
                DataInfo.Cat cat = msg.getCat();
                System.out.println(cat.getName());
                System.out.println(cat.getCity());
                break;
        }
    }
}
