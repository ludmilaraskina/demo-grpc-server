package com.example.barcode.server.grpc;

import com.example.barcode.server.grpc.service.DemoServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class GrpcServer {

    @Value("${server.port}")
    private int serverPort;

    @PostConstruct
    void init() throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(serverPort)
                .addService(new DemoServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
