package org.devolpex.backend.stubs.main;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Reservation Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: main.proto")
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final String SERVICE_NAME = "org.devolpex.backend.stubs.main.ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.GetReservationsListREQ,
      org.devolpex.backend.stubs.reservation.GetReservationsListRES> getFetchReservationListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchReservationList",
      requestType = org.devolpex.backend.stubs.reservation.GetReservationsListREQ.class,
      responseType = org.devolpex.backend.stubs.reservation.GetReservationsListRES.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.GetReservationsListREQ,
      org.devolpex.backend.stubs.reservation.GetReservationsListRES> getFetchReservationListMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.GetReservationsListREQ, org.devolpex.backend.stubs.reservation.GetReservationsListRES> getFetchReservationListMethod;
    if ((getFetchReservationListMethod = ReservationServiceGrpc.getFetchReservationListMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getFetchReservationListMethod = ReservationServiceGrpc.getFetchReservationListMethod) == null) {
          ReservationServiceGrpc.getFetchReservationListMethod = getFetchReservationListMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.reservation.GetReservationsListREQ, org.devolpex.backend.stubs.reservation.GetReservationsListRES>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.devolpex.backend.stubs.main.ReservationService", "FetchReservationList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.GetReservationsListREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.GetReservationsListRES.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("FetchReservationList"))
                  .build();
          }
        }
     }
     return getFetchReservationListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.GetReservationPageREQ,
      org.devolpex.backend.stubs.reservation.GetReservationPageRES> getFetchReservationPageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchReservationPage",
      requestType = org.devolpex.backend.stubs.reservation.GetReservationPageREQ.class,
      responseType = org.devolpex.backend.stubs.reservation.GetReservationPageRES.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.GetReservationPageREQ,
      org.devolpex.backend.stubs.reservation.GetReservationPageRES> getFetchReservationPageMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.GetReservationPageREQ, org.devolpex.backend.stubs.reservation.GetReservationPageRES> getFetchReservationPageMethod;
    if ((getFetchReservationPageMethod = ReservationServiceGrpc.getFetchReservationPageMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getFetchReservationPageMethod = ReservationServiceGrpc.getFetchReservationPageMethod) == null) {
          ReservationServiceGrpc.getFetchReservationPageMethod = getFetchReservationPageMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.reservation.GetReservationPageREQ, org.devolpex.backend.stubs.reservation.GetReservationPageRES>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.devolpex.backend.stubs.main.ReservationService", "FetchReservationPage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.GetReservationPageREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.GetReservationPageRES.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("FetchReservationPage"))
                  .build();
          }
        }
     }
     return getFetchReservationPageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.GetReservationByIdREQ,
      org.devolpex.backend.stubs.reservation.GetReservationByIdRES> getFetchReservationByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchReservationById",
      requestType = org.devolpex.backend.stubs.reservation.GetReservationByIdREQ.class,
      responseType = org.devolpex.backend.stubs.reservation.GetReservationByIdRES.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.GetReservationByIdREQ,
      org.devolpex.backend.stubs.reservation.GetReservationByIdRES> getFetchReservationByIdMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.GetReservationByIdREQ, org.devolpex.backend.stubs.reservation.GetReservationByIdRES> getFetchReservationByIdMethod;
    if ((getFetchReservationByIdMethod = ReservationServiceGrpc.getFetchReservationByIdMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getFetchReservationByIdMethod = ReservationServiceGrpc.getFetchReservationByIdMethod) == null) {
          ReservationServiceGrpc.getFetchReservationByIdMethod = getFetchReservationByIdMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.reservation.GetReservationByIdREQ, org.devolpex.backend.stubs.reservation.GetReservationByIdRES>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.devolpex.backend.stubs.main.ReservationService", "FetchReservationById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.GetReservationByIdREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.GetReservationByIdRES.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("FetchReservationById"))
                  .build();
          }
        }
     }
     return getFetchReservationByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.ReservationREQ,
      org.devolpex.backend.stubs.reservation.ReservationRES> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReservation",
      requestType = org.devolpex.backend.stubs.reservation.ReservationREQ.class,
      responseType = org.devolpex.backend.stubs.reservation.ReservationRES.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.ReservationREQ,
      org.devolpex.backend.stubs.reservation.ReservationRES> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.ReservationREQ, org.devolpex.backend.stubs.reservation.ReservationRES> getCreateReservationMethod;
    if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
          ReservationServiceGrpc.getCreateReservationMethod = getCreateReservationMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.reservation.ReservationREQ, org.devolpex.backend.stubs.reservation.ReservationRES>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.devolpex.backend.stubs.main.ReservationService", "CreateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.ReservationREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.ReservationRES.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("CreateReservation"))
                  .build();
          }
        }
     }
     return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.UpdateReservationREQ,
      org.devolpex.backend.stubs.reservation.ReservationRES> getUpdateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReservation",
      requestType = org.devolpex.backend.stubs.reservation.UpdateReservationREQ.class,
      responseType = org.devolpex.backend.stubs.reservation.ReservationRES.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.UpdateReservationREQ,
      org.devolpex.backend.stubs.reservation.ReservationRES> getUpdateReservationMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.UpdateReservationREQ, org.devolpex.backend.stubs.reservation.ReservationRES> getUpdateReservationMethod;
    if ((getUpdateReservationMethod = ReservationServiceGrpc.getUpdateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getUpdateReservationMethod = ReservationServiceGrpc.getUpdateReservationMethod) == null) {
          ReservationServiceGrpc.getUpdateReservationMethod = getUpdateReservationMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.reservation.UpdateReservationREQ, org.devolpex.backend.stubs.reservation.ReservationRES>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.devolpex.backend.stubs.main.ReservationService", "UpdateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.UpdateReservationREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.ReservationRES.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("UpdateReservation"))
                  .build();
          }
        }
     }
     return getUpdateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.DeleteReservationREQ,
      com.google.protobuf.Empty> getDeleteReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReservation",
      requestType = org.devolpex.backend.stubs.reservation.DeleteReservationREQ.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.DeleteReservationREQ,
      com.google.protobuf.Empty> getDeleteReservationMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.reservation.DeleteReservationREQ, com.google.protobuf.Empty> getDeleteReservationMethod;
    if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod) == null) {
          ReservationServiceGrpc.getDeleteReservationMethod = getDeleteReservationMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.reservation.DeleteReservationREQ, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.devolpex.backend.stubs.main.ReservationService", "DeleteReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.reservation.DeleteReservationREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("DeleteReservation"))
                  .build();
          }
        }
     }
     return getDeleteReservationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    return new ReservationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReservationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReservationServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Reservation Service
   * </pre>
   */
  public static abstract class ReservationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetchReservationList(org.devolpex.backend.stubs.reservation.GetReservationsListREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.GetReservationsListRES> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchReservationListMethod(), responseObserver);
    }

    /**
     */
    public void fetchReservationPage(org.devolpex.backend.stubs.reservation.GetReservationPageREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.GetReservationPageRES> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchReservationPageMethod(), responseObserver);
    }

    /**
     */
    public void fetchReservationById(org.devolpex.backend.stubs.reservation.GetReservationByIdREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.GetReservationByIdRES> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchReservationByIdMethod(), responseObserver);
    }

    /**
     */
    public void createReservation(org.devolpex.backend.stubs.reservation.ReservationREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.ReservationRES> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     */
    public void updateReservation(org.devolpex.backend.stubs.reservation.UpdateReservationREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.ReservationRES> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateReservationMethod(), responseObserver);
    }

    /**
     */
    public void deleteReservation(org.devolpex.backend.stubs.reservation.DeleteReservationREQ request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteReservationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchReservationListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.reservation.GetReservationsListREQ,
                org.devolpex.backend.stubs.reservation.GetReservationsListRES>(
                  this, METHODID_FETCH_RESERVATION_LIST)))
          .addMethod(
            getFetchReservationPageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.reservation.GetReservationPageREQ,
                org.devolpex.backend.stubs.reservation.GetReservationPageRES>(
                  this, METHODID_FETCH_RESERVATION_PAGE)))
          .addMethod(
            getFetchReservationByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.reservation.GetReservationByIdREQ,
                org.devolpex.backend.stubs.reservation.GetReservationByIdRES>(
                  this, METHODID_FETCH_RESERVATION_BY_ID)))
          .addMethod(
            getCreateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.reservation.ReservationREQ,
                org.devolpex.backend.stubs.reservation.ReservationRES>(
                  this, METHODID_CREATE_RESERVATION)))
          .addMethod(
            getUpdateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.reservation.UpdateReservationREQ,
                org.devolpex.backend.stubs.reservation.ReservationRES>(
                  this, METHODID_UPDATE_RESERVATION)))
          .addMethod(
            getDeleteReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.reservation.DeleteReservationREQ,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_RESERVATION)))
          .build();
    }
  }

  /**
   * <pre>
   * Reservation Service
   * </pre>
   */
  public static final class ReservationServiceStub extends io.grpc.stub.AbstractStub<ReservationServiceStub> {
    private ReservationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetchReservationList(org.devolpex.backend.stubs.reservation.GetReservationsListREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.GetReservationsListRES> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchReservationListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fetchReservationPage(org.devolpex.backend.stubs.reservation.GetReservationPageREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.GetReservationPageRES> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchReservationPageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fetchReservationById(org.devolpex.backend.stubs.reservation.GetReservationByIdREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.GetReservationByIdRES> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchReservationByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createReservation(org.devolpex.backend.stubs.reservation.ReservationREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.ReservationRES> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateReservation(org.devolpex.backend.stubs.reservation.UpdateReservationREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.ReservationRES> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteReservation(org.devolpex.backend.stubs.reservation.DeleteReservationREQ request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Reservation Service
   * </pre>
   */
  public static final class ReservationServiceBlockingStub extends io.grpc.stub.AbstractStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.devolpex.backend.stubs.reservation.GetReservationsListRES fetchReservationList(org.devolpex.backend.stubs.reservation.GetReservationsListREQ request) {
      return blockingUnaryCall(
          getChannel(), getFetchReservationListMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.devolpex.backend.stubs.reservation.GetReservationPageRES fetchReservationPage(org.devolpex.backend.stubs.reservation.GetReservationPageREQ request) {
      return blockingUnaryCall(
          getChannel(), getFetchReservationPageMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.devolpex.backend.stubs.reservation.GetReservationByIdRES fetchReservationById(org.devolpex.backend.stubs.reservation.GetReservationByIdREQ request) {
      return blockingUnaryCall(
          getChannel(), getFetchReservationByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.devolpex.backend.stubs.reservation.ReservationRES createReservation(org.devolpex.backend.stubs.reservation.ReservationREQ request) {
      return blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.devolpex.backend.stubs.reservation.ReservationRES updateReservation(org.devolpex.backend.stubs.reservation.UpdateReservationREQ request) {
      return blockingUnaryCall(
          getChannel(), getUpdateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteReservation(org.devolpex.backend.stubs.reservation.DeleteReservationREQ request) {
      return blockingUnaryCall(
          getChannel(), getDeleteReservationMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Reservation Service
   * </pre>
   */
  public static final class ReservationServiceFutureStub extends io.grpc.stub.AbstractStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.reservation.GetReservationsListRES> fetchReservationList(
        org.devolpex.backend.stubs.reservation.GetReservationsListREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchReservationListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.reservation.GetReservationPageRES> fetchReservationPage(
        org.devolpex.backend.stubs.reservation.GetReservationPageREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchReservationPageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.reservation.GetReservationByIdRES> fetchReservationById(
        org.devolpex.backend.stubs.reservation.GetReservationByIdREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchReservationByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.reservation.ReservationRES> createReservation(
        org.devolpex.backend.stubs.reservation.ReservationREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.reservation.ReservationRES> updateReservation(
        org.devolpex.backend.stubs.reservation.UpdateReservationREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteReservation(
        org.devolpex.backend.stubs.reservation.DeleteReservationREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_RESERVATION_LIST = 0;
  private static final int METHODID_FETCH_RESERVATION_PAGE = 1;
  private static final int METHODID_FETCH_RESERVATION_BY_ID = 2;
  private static final int METHODID_CREATE_RESERVATION = 3;
  private static final int METHODID_UPDATE_RESERVATION = 4;
  private static final int METHODID_DELETE_RESERVATION = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReservationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReservationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_RESERVATION_LIST:
          serviceImpl.fetchReservationList((org.devolpex.backend.stubs.reservation.GetReservationsListREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.GetReservationsListRES>) responseObserver);
          break;
        case METHODID_FETCH_RESERVATION_PAGE:
          serviceImpl.fetchReservationPage((org.devolpex.backend.stubs.reservation.GetReservationPageREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.GetReservationPageRES>) responseObserver);
          break;
        case METHODID_FETCH_RESERVATION_BY_ID:
          serviceImpl.fetchReservationById((org.devolpex.backend.stubs.reservation.GetReservationByIdREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.GetReservationByIdRES>) responseObserver);
          break;
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((org.devolpex.backend.stubs.reservation.ReservationREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.ReservationRES>) responseObserver);
          break;
        case METHODID_UPDATE_RESERVATION:
          serviceImpl.updateReservation((org.devolpex.backend.stubs.reservation.UpdateReservationREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.reservation.ReservationRES>) responseObserver);
          break;
        case METHODID_DELETE_RESERVATION:
          serviceImpl.deleteReservation((org.devolpex.backend.stubs.reservation.DeleteReservationREQ) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.devolpex.backend.stubs.main.Main.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
              .addMethod(getFetchReservationListMethod())
              .addMethod(getFetchReservationPageMethod())
              .addMethod(getFetchReservationByIdMethod())
              .addMethod(getCreateReservationMethod())
              .addMethod(getUpdateReservationMethod())
              .addMethod(getDeleteReservationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
