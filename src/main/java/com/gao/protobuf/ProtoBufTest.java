package com.gao.protobuf;

public class ProtoBufTest {

    public static void main(String[] args) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三")
                .setAge(25).setAddress("北京朝阳门").build();
        byte[] stuBytes = student.toByteArray();
        DataInfo.Student student2 = DataInfo.Student.parseFrom(stuBytes);
        //System.out.println(student2);
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getAddress());
    }
}
