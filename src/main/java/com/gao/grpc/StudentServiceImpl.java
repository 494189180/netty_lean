package com.gao.grpc;

import com.gao.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端信息：" + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接收到客户端信息：" + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName("zs").setAge(22).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("zs").setAge(22).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("zs").setAge(22).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("zs").setAge(22).setCity("北京").build());
        responseObserver.onCompleted();

    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {

                StudentResponse studentResponse1 = StudentResponse.newBuilder().setName("zs").setAge(22).setCity("xa").build();
                StudentResponse studentResponse2 = StudentResponse.newBuilder().setName("zs").setAge(22).setCity("xa").build();
                StudentResponseList studentResponseList = StudentResponseList.newBuilder()
                        .addStudentResponse(studentResponse1)
                        .addStudentResponse(studentResponse2).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();

            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());

            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}



















