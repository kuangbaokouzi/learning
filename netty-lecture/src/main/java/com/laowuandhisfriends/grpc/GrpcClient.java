package com.laowuandhisfriends.grpc;


import com.laowuandhisfriends.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class GrpcClient {
    private final ManagedChannel channel;
    private final StudentServiceGrpc.StudentServiceBlockingStub blockingStub;
    private final StudentServiceGrpc.StudentServiceStub serviceStub;

    public GrpcClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true));
    }

    GrpcClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = StudentServiceGrpc.newBlockingStub(channel);
        serviceStub = StudentServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void messageToMessage(String name) {
        MyRequest request = MyRequest.newBuilder().setUsername(name).build();
        MyResponse response;
        try {
            response = blockingStub.getRealnameByUsername(request);
            System.out.println("Got Server Message: " + response.getRealname());
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return;
        }
    }

    public void messageToStream(Integer age) {
        StudentRequest request = StudentRequest.newBuilder().setAge(age).build();
        Iterator<StudentResponse> it;
        try {
            it = blockingStub.getStudentByAge(request);
            System.out.println("Got Server Message: ");
            while (it.hasNext()) {
                StudentResponse response = it.next();
                System.out.println(response.getName() + "," + response.getAge() + "," + response.getCity());
            }
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return;
        }
    }

    public void streamToMessageList() {
        StreamObserver<StudentResponseList> responseStreamObserver = new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {
                System.out.println("Got Server Message: ");
                value.getStudentResponseList().forEach(studentResponse -> {
                    System.out.println(studentResponse.getName());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println("+++++++++++++++++");
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }
        };

        StreamObserver<StudentRequest> requestStreamObserver =
                serviceStub.getStudentWrapperByAges(responseStreamObserver);

        requestStreamObserver.onNext(StudentRequest.newBuilder()
                .setAge(20)
                .build());
        requestStreamObserver.onNext(StudentRequest.newBuilder()
                .setAge(30)
                .build());
        requestStreamObserver.onNext(StudentRequest.newBuilder()
                .setAge(40)
                .build());
        requestStreamObserver.onNext(StudentRequest.newBuilder()
                .setAge(50)
                .build());
        requestStreamObserver.onCompleted();
    }

    public void streamToStream() {
        StreamObserver<StreamRequest> requestStreamObserver = serviceStub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println("Got Server Message: " + value.getResponseInfo());
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
            requestStreamObserver.onNext(StreamRequest.newBuilder()
                    .setReqeustInfo(LocalTime.now().toString())
                    .build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        GrpcClient grpcClient = new GrpcClient("localhost", 8899);
        try {
            /* Access a service running on the local machine on port 50051 */
            grpcClient.messageToMessage("laozhang");
            System.out.println("++++++++++++++++++++++");
            grpcClient.messageToStream(20);
            System.out.println("++++++++++++++++++++++");
            grpcClient.streamToMessageList();
            System.out.println("++++++++++++++++++++++");
            grpcClient.streamToStream();
        } finally {
            grpcClient.shutdown();
        }
    }
}
