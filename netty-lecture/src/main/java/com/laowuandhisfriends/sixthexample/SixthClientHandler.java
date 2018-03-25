package com.laowuandhisfriends.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class SixthClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Random random = new Random();
        int randomNum = random.nextInt(3);
        MyDataInfo.MyMessage myMessage = null;
        if (0 == randomNum) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder()
                            .setName("Jason")
                            .setAge(30)
                            .setAddress("shanghai")
                            .build()
                    )
                    .build();
        } else if (1 == randomNum) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder()
                            .setName("wangwang")
                            .setAge(3)
                            .build()
                    )
                    .build();
        } else {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.CatType)
                    .setCat(MyDataInfo.Cat.newBuilder()
                            .setName("miaomiao")
                            .setCity("wuhan")
                            .build()
                    )
                    .build();
        }
        ctx.channel().writeAndFlush(myMessage);
    }
}
