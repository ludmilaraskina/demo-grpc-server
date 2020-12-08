package com.example.barcode.server;

import com.example.barcode.api.grpc.DemoRequest;
import com.example.barcode.api.grpc.DemoResponse;
import com.example.barcode.api.grpc.DemoServiceGrpc;
import com.example.barcode.server.grpc.GrpcServer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ServerApplicationTests {

    @Value("${server.port}")
    private int serverPort;

    @MockBean
    GrpcServer grpcServer;

    @Test
    void testClient() {
        ManagedChannel mChannel = ManagedChannelBuilder
                .forAddress("192.168.0.141", serverPort)
                .usePlaintext()
                .build();
        DemoServiceGrpc.DemoServiceBlockingStub stub
                = DemoServiceGrpc.newBlockingStub(mChannel);

        DemoRequest demoRequest = DemoRequest.newBuilder()
                .setMessage("from test")
                .build();
        DemoResponse demoResponse = stub.demo(demoRequest);
        assertEquals("Server received message: " + demoRequest.getMessage(), demoResponse.getStatusText());
    }

}
