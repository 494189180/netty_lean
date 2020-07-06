package com.gao.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.myMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.myMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);
        System.out.println("randomInt:" + randomInt);
        DataInfo.myMessage myMessage = null;
        switch (randomInt) {
            case 0:
                myMessage = DataInfo.myMessage.newBuilder().setDataType(DataInfo.myMessage.DataType.PersonType)
                        .setPerson(DataInfo.Person.newBuilder()
                                .setName("张一")
                                .setAge(23)
                                .setAddress("朝阳门外")
                                .build())
                        .build();
                break;
            case 1:
                myMessage = DataInfo.myMessage.newBuilder().setDataType(DataInfo.myMessage.DataType.DogType)
                        .setDog(DataInfo.Dog.newBuilder()
                                .setName("小黑")
                                .setAge(3)
                                .build())
                        .build();
                break;
            default:
                myMessage = DataInfo.myMessage.newBuilder().setDataType(DataInfo.myMessage.DataType.CatType)
                        .setCat(DataInfo.Cat.newBuilder()
                                .setName("小黑")
                                .setCity(3)
                                .build())
                        .build();
                break;
        }
        ctx.channel().writeAndFlush(myMessage);
    }
}
