package com.example.proto.toll;

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
    comments = "Source: toll.proto")
public final class TollServiceGrpc {

  private TollServiceGrpc() {}

  public static final String SERVICE_NAME = "toll.TollService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.proto.toll.TollProto.TollPriceRequest,
      com.example.proto.toll.TollProto.TollPriceResponse> METHOD_GET_TOLL_PRICE =
      io.grpc.MethodDescriptor.<com.example.proto.toll.TollProto.TollPriceRequest, com.example.proto.toll.TollProto.TollPriceResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "toll.TollService", "GetTollPrice"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.proto.toll.TollProto.TollPriceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.proto.toll.TollProto.TollPriceResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TollServiceStub newStub(io.grpc.Channel channel) {
    return new TollServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TollServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TollServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TollServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TollServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TollServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTollPrice(com.example.proto.toll.TollProto.TollPriceRequest request,
        io.grpc.stub.StreamObserver<com.example.proto.toll.TollProto.TollPriceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_TOLL_PRICE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_TOLL_PRICE,
            asyncUnaryCall(
              new MethodHandlers<
                com.example.proto.toll.TollProto.TollPriceRequest,
                com.example.proto.toll.TollProto.TollPriceResponse>(
                  this, METHODID_GET_TOLL_PRICE)))
          .build();
    }
  }

  /**
   */
  public static final class TollServiceStub extends io.grpc.stub.AbstractStub<TollServiceStub> {
    private TollServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TollServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TollServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TollServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTollPrice(com.example.proto.toll.TollProto.TollPriceRequest request,
        io.grpc.stub.StreamObserver<com.example.proto.toll.TollProto.TollPriceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TOLL_PRICE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TollServiceBlockingStub extends io.grpc.stub.AbstractStub<TollServiceBlockingStub> {
    private TollServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TollServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TollServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TollServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.proto.toll.TollProto.TollPriceResponse getTollPrice(com.example.proto.toll.TollProto.TollPriceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_TOLL_PRICE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TollServiceFutureStub extends io.grpc.stub.AbstractStub<TollServiceFutureStub> {
    private TollServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TollServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TollServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TollServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.proto.toll.TollProto.TollPriceResponse> getTollPrice(
        com.example.proto.toll.TollProto.TollPriceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TOLL_PRICE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TOLL_PRICE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TollServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TollServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TOLL_PRICE:
          serviceImpl.getTollPrice((com.example.proto.toll.TollProto.TollPriceRequest) request,
              (io.grpc.stub.StreamObserver<com.example.proto.toll.TollProto.TollPriceResponse>) responseObserver);
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

  private static final class TollServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.proto.toll.TollProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TollServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TollServiceDescriptorSupplier())
              .addMethod(METHOD_GET_TOLL_PRICE)
              .build();
        }
      }
    }
    return result;
  }
}
