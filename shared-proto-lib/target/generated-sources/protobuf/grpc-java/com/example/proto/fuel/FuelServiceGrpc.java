package com.example.proto.fuel;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: fuel.proto")
public final class FuelServiceGrpc {

  private FuelServiceGrpc() {}

  public static final String SERVICE_NAME = "fuel.FuelService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.proto.fuel.FuelProto.FuelPriceRequest,
      com.example.proto.fuel.FuelProto.FuelPriceResponse> METHOD_GET_FUEL_PRICE =
      io.grpc.MethodDescriptor.<com.example.proto.fuel.FuelProto.FuelPriceRequest, com.example.proto.fuel.FuelProto.FuelPriceResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "fuel.FuelService", "GetFuelPrice"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.proto.fuel.FuelProto.FuelPriceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.proto.fuel.FuelProto.FuelPriceResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FuelServiceStub newStub(io.grpc.Channel channel) {
    return new FuelServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FuelServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FuelServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FuelServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FuelServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FuelServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFuelPrice(com.example.proto.fuel.FuelProto.FuelPriceRequest request,
        io.grpc.stub.StreamObserver<com.example.proto.fuel.FuelProto.FuelPriceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FUEL_PRICE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_FUEL_PRICE,
            asyncUnaryCall(
              new MethodHandlers<
                com.example.proto.fuel.FuelProto.FuelPriceRequest,
                com.example.proto.fuel.FuelProto.FuelPriceResponse>(
                  this, METHODID_GET_FUEL_PRICE)))
          .build();
    }
  }

  /**
   */
  public static final class FuelServiceStub extends io.grpc.stub.AbstractStub<FuelServiceStub> {
    private FuelServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FuelServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FuelServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FuelServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFuelPrice(com.example.proto.fuel.FuelProto.FuelPriceRequest request,
        io.grpc.stub.StreamObserver<com.example.proto.fuel.FuelProto.FuelPriceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FUEL_PRICE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FuelServiceBlockingStub extends io.grpc.stub.AbstractStub<FuelServiceBlockingStub> {
    private FuelServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FuelServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FuelServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FuelServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.proto.fuel.FuelProto.FuelPriceResponse getFuelPrice(com.example.proto.fuel.FuelProto.FuelPriceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FUEL_PRICE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FuelServiceFutureStub extends io.grpc.stub.AbstractStub<FuelServiceFutureStub> {
    private FuelServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FuelServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FuelServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FuelServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.proto.fuel.FuelProto.FuelPriceResponse> getFuelPrice(
        com.example.proto.fuel.FuelProto.FuelPriceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FUEL_PRICE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FUEL_PRICE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FuelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FuelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FUEL_PRICE:
          serviceImpl.getFuelPrice((com.example.proto.fuel.FuelProto.FuelPriceRequest) request,
              (io.grpc.stub.StreamObserver<com.example.proto.fuel.FuelProto.FuelPriceResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class FuelServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.proto.fuel.FuelProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FuelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FuelServiceDescriptorSupplier())
              .addMethod(METHOD_GET_FUEL_PRICE)
              .build();
        }
      }
    }
    return result;
  }
}
