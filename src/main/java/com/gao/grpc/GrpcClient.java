package com.gao.grpc;

import com.gao.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());
        System.out.println(myResponse.getRealname());
        System.out.println("---------------------普通传递");
        Iterator<StudentResponse> iter = blockingStub.getStudentByAge(StudentRequest.newBuilder().setAge(32).build());
        while (iter.hasNext()) {
            StudentResponse next = iter.next();
            System.out.println(next.getName() + "," + next.getAge() + "," + next.getCity());
        }
        System.out.println("---------------------响应流式");
        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {
                value.getStudentResponseList().forEach(studentResponse -> {
                    System.out.println(studentResponse.getName());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println("***************");
                });
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        };
        StreamObserver<StudentRequest> studentsWrapperByAges = stub.getStudentsWrapperByAges(studentResponseListStreamObserver);
        studentsWrapperByAges.onNext(StudentRequest.newBuilder().setAge(22).build());
        studentsWrapperByAges.onCompleted();
        Thread.sleep(1000);
        System.out.println("----------------请求流式");
        StreamObserver<StreamRequest> requestStreamObserver = stub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });
        for (int i = 0; i < 10; i++) {
            requestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
            Thread.sleep(1000);
        }

        Thread.sleep(50000);
        System.out.println("-----------------流式双向传递");



    }
}
