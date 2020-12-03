//package com.example.barcode.server.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import com.example.barcode.api.grpc.DemoRequest;
//import com.example.barcode.api.grpc.DemoResponse;
//
//@RestController
//public class DemoController {
//
//    private final ObjectMapper objectMapper;
//
//    static Logger logger = LoggerFactory.getLogger(DemoController.class);
//
//    public DemoController(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @PostMapping("/demo")
//    public DemoResponse getReport(@RequestBody DemoRequest request) throws JsonProcessingException {
//        logger.info("Received request:" + objectMapper.writeValueAsString(request));
//
//        return DemoResponse.newBuilder().setRequest(request).build();
//    }
//}
