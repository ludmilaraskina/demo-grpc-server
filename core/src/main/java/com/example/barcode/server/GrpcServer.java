package com.example.barcode.server;

import com.example.barcode.server.grpc.service.DemoServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class GrpcServer {

    @PostConstruct
    void init() throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8081)
                .addService(new DemoServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
