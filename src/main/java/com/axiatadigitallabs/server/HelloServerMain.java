package com.axiatadigitallabs.server;


import com.axiatadigitallabs.grpc.HelloRequest;
import com.axiatadigitallabs.grpc.HelloResponse;
import com.axiatadigitallabs.grpc.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

class HelloServer  {
    Server server;

    void start() throws IOException {
        server = ServerBuilder.forPort(8080)
                .addService(new HelloService())
                .build().start();
   }

    private void stop() {
          if (server != null) {
                server.shutdown();
          }
    }

}

class HelloService extends HelloServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage("Hello from server " + request.getName())
                .build();

        System.out.printf("Server received: %s%n", request.getName());

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}


public class HelloServerMain {
    public static void main(String[] args) throws Exception {
        HelloServer server = new HelloServer();
        server.start();
        server.server.awaitTermination();
    }
}
