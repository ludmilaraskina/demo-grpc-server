package com.example.barcode.server.grpc.service;

import com.example.barcode.api.grpc.DemoRequest;
import com.example.barcode.api.grpc.DemoResponse;
import com.example.barcode.api.grpc.DemoServiceGrpc;
import io.grpc.stub.StreamObserver;

public class DemoServiceImpl extends DemoServiceGrpc.DemoServiceImplBase {

    @Override
    public void demo(DemoRequest request,
                     StreamObserver<DemoResponse> responseObserver) {
        DemoResponse response = DemoResponse.newBuilder().setStatusText("Server received message: " + request.getMessage()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
