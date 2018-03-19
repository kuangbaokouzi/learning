package com.laowuandhisfriends.grpc;

import com.laowuandhisfriends.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealnameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("Got Client Message: " + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder()
                .setRealname("zhangsan")
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("Got Client Message: " + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder()
                .setName("laozhang")
                .setAge(40)
                .setCity("nanning")
                .build());
        responseObserver.onNext(StudentResponse.newBuilder()
                .setName("laowang")
                .setAge(30)
                .setCity("beijing")
                .build());
        responseObserver.onNext(StudentResponse.newBuilder()
                .setName("laowu")
                .setAge(28)
                .setCity("shenzhen")
                .build());
        responseObserver.onNext(StudentResponse.newBuilder()
                .setName("laoli")
                .setAge(33)
                .setCity("shanghai")
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("Got Client Message: " + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                StudentResponse response1 = StudentResponse.newBuilder()
                        .setName("laozhang")
                        .setAge(20)
                        .setCity("beijing")
                        .build();
                StudentResponse response2 = StudentResponse.newBuilder()
                        .setName("laowu")
                        .setAge(30)
                        .setCity("shanghai")
                        .build();
                StudentResponseList responseList = StudentResponseList.newBuilder()
                        .addStudentResponse(response1)
                        .addStudentResponse(response2)
                        .build();
                responseObserver.onNext(responseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println("Got Client Message: " + value.getReqeustInfo());

                responseObserver.onNext(StreamResponse.newBuilder()
                        .setResponseInfo(UUID.randomUUID().toString())
                        .build());
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
