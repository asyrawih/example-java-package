package com.axiatadigitallabs.client;

import com.axiatadigitallabs.grpc.HelloRequest;
import com.axiatadigitallabs.grpc.HelloResponse;
import com.axiatadigitallabs.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {
    private final HelloServiceGrpc.HelloServiceBlockingStub stub;

    public HelloClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        stub = HelloServiceGrpc.newBlockingStub(channel);
    }

    public void greet(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloResponse response = stub.sayHello(request);
        System.out.println(response.getMessage());
    }

    public static void main(String[] args) {
        HelloClient client = new HelloClient("localhost", 8080);
        client.greet("John Doe");
    }

}
