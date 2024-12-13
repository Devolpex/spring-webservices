package org.devolpex.backend.stubs.client;

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
 * Services
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: client.proto")
public final class ClientServiceGrpc {

  private ClientServiceGrpc() {}

  public static final String SERVICE_NAME = "ClientService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.FetchListClientsREQ,
      org.devolpex.backend.stubs.client.FetchListClientsRES> getFetchListClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchListClients",
      requestType = org.devolpex.backend.stubs.client.FetchListClientsREQ.class,
      responseType = org.devolpex.backend.stubs.client.FetchListClientsRES.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.FetchListClientsREQ,
      org.devolpex.backend.stubs.client.FetchListClientsRES> getFetchListClientsMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.FetchListClientsREQ, org.devolpex.backend.stubs.client.FetchListClientsRES> getFetchListClientsMethod;
    if ((getFetchListClientsMethod = ClientServiceGrpc.getFetchListClientsMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getFetchListClientsMethod = ClientServiceGrpc.getFetchListClientsMethod) == null) {
          ClientServiceGrpc.getFetchListClientsMethod = getFetchListClientsMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.client.FetchListClientsREQ, org.devolpex.backend.stubs.client.FetchListClientsRES>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "FetchListClients"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.FetchListClientsREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.FetchListClientsRES.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("FetchListClients"))
                  .build();
          }
        }
     }
     return getFetchListClientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.FetchClientByIdREQ,
      org.devolpex.backend.stubs.client.FetchClientByIdRES> getFetchClientByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchClientById",
      requestType = org.devolpex.backend.stubs.client.FetchClientByIdREQ.class,
      responseType = org.devolpex.backend.stubs.client.FetchClientByIdRES.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.FetchClientByIdREQ,
      org.devolpex.backend.stubs.client.FetchClientByIdRES> getFetchClientByIdMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.FetchClientByIdREQ, org.devolpex.backend.stubs.client.FetchClientByIdRES> getFetchClientByIdMethod;
    if ((getFetchClientByIdMethod = ClientServiceGrpc.getFetchClientByIdMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getFetchClientByIdMethod = ClientServiceGrpc.getFetchClientByIdMethod) == null) {
          ClientServiceGrpc.getFetchClientByIdMethod = getFetchClientByIdMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.client.FetchClientByIdREQ, org.devolpex.backend.stubs.client.FetchClientByIdRES>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "FetchClientById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.FetchClientByIdREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.FetchClientByIdRES.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("FetchClientById"))
                  .build();
          }
        }
     }
     return getFetchClientByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.FetchPageClientsREQ,
      org.devolpex.backend.stubs.client.FetchPageClientsRES> getFetchPageClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchPageClients",
      requestType = org.devolpex.backend.stubs.client.FetchPageClientsREQ.class,
      responseType = org.devolpex.backend.stubs.client.FetchPageClientsRES.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.FetchPageClientsREQ,
      org.devolpex.backend.stubs.client.FetchPageClientsRES> getFetchPageClientsMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.FetchPageClientsREQ, org.devolpex.backend.stubs.client.FetchPageClientsRES> getFetchPageClientsMethod;
    if ((getFetchPageClientsMethod = ClientServiceGrpc.getFetchPageClientsMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getFetchPageClientsMethod = ClientServiceGrpc.getFetchPageClientsMethod) == null) {
          ClientServiceGrpc.getFetchPageClientsMethod = getFetchPageClientsMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.client.FetchPageClientsREQ, org.devolpex.backend.stubs.client.FetchPageClientsRES>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "FetchPageClients"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.FetchPageClientsREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.FetchPageClientsRES.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("FetchPageClients"))
                  .build();
          }
        }
     }
     return getFetchPageClientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.CreateClientREQ,
      org.devolpex.backend.stubs.client.ClientPRT> getCreateClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateClient",
      requestType = org.devolpex.backend.stubs.client.CreateClientREQ.class,
      responseType = org.devolpex.backend.stubs.client.ClientPRT.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.CreateClientREQ,
      org.devolpex.backend.stubs.client.ClientPRT> getCreateClientMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.CreateClientREQ, org.devolpex.backend.stubs.client.ClientPRT> getCreateClientMethod;
    if ((getCreateClientMethod = ClientServiceGrpc.getCreateClientMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getCreateClientMethod = ClientServiceGrpc.getCreateClientMethod) == null) {
          ClientServiceGrpc.getCreateClientMethod = getCreateClientMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.client.CreateClientREQ, org.devolpex.backend.stubs.client.ClientPRT>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "CreateClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.CreateClientREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.ClientPRT.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("CreateClient"))
                  .build();
          }
        }
     }
     return getCreateClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.UpdateClientREQ,
      org.devolpex.backend.stubs.client.ClientPRT> getUpdateClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateClient",
      requestType = org.devolpex.backend.stubs.client.UpdateClientREQ.class,
      responseType = org.devolpex.backend.stubs.client.ClientPRT.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.UpdateClientREQ,
      org.devolpex.backend.stubs.client.ClientPRT> getUpdateClientMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.UpdateClientREQ, org.devolpex.backend.stubs.client.ClientPRT> getUpdateClientMethod;
    if ((getUpdateClientMethod = ClientServiceGrpc.getUpdateClientMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getUpdateClientMethod = ClientServiceGrpc.getUpdateClientMethod) == null) {
          ClientServiceGrpc.getUpdateClientMethod = getUpdateClientMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.client.UpdateClientREQ, org.devolpex.backend.stubs.client.ClientPRT>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "UpdateClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.UpdateClientREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.ClientPRT.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("UpdateClient"))
                  .build();
          }
        }
     }
     return getUpdateClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.DeleteClientREQ,
      com.google.protobuf.Empty> getDeleteClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteClient",
      requestType = org.devolpex.backend.stubs.client.DeleteClientREQ.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.DeleteClientREQ,
      com.google.protobuf.Empty> getDeleteClientMethod() {
    io.grpc.MethodDescriptor<org.devolpex.backend.stubs.client.DeleteClientREQ, com.google.protobuf.Empty> getDeleteClientMethod;
    if ((getDeleteClientMethod = ClientServiceGrpc.getDeleteClientMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getDeleteClientMethod = ClientServiceGrpc.getDeleteClientMethod) == null) {
          ClientServiceGrpc.getDeleteClientMethod = getDeleteClientMethod = 
              io.grpc.MethodDescriptor.<org.devolpex.backend.stubs.client.DeleteClientREQ, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "DeleteClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.devolpex.backend.stubs.client.DeleteClientREQ.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("DeleteClient"))
                  .build();
          }
        }
     }
     return getDeleteClientMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientServiceStub newStub(io.grpc.Channel channel) {
    return new ClientServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Services
   * </pre>
   */
  public static abstract class ClientServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetchListClients(org.devolpex.backend.stubs.client.FetchListClientsREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.FetchListClientsRES> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchListClientsMethod(), responseObserver);
    }

    /**
     */
    public void fetchClientById(org.devolpex.backend.stubs.client.FetchClientByIdREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.FetchClientByIdRES> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchClientByIdMethod(), responseObserver);
    }

    /**
     */
    public void fetchPageClients(org.devolpex.backend.stubs.client.FetchPageClientsREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.FetchPageClientsRES> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchPageClientsMethod(), responseObserver);
    }

    /**
     */
    public void createClient(org.devolpex.backend.stubs.client.CreateClientREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.ClientPRT> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateClientMethod(), responseObserver);
    }

    /**
     */
    public void updateClient(org.devolpex.backend.stubs.client.UpdateClientREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.ClientPRT> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateClientMethod(), responseObserver);
    }

    /**
     */
    public void deleteClient(org.devolpex.backend.stubs.client.DeleteClientREQ request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteClientMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchListClientsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.client.FetchListClientsREQ,
                org.devolpex.backend.stubs.client.FetchListClientsRES>(
                  this, METHODID_FETCH_LIST_CLIENTS)))
          .addMethod(
            getFetchClientByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.client.FetchClientByIdREQ,
                org.devolpex.backend.stubs.client.FetchClientByIdRES>(
                  this, METHODID_FETCH_CLIENT_BY_ID)))
          .addMethod(
            getFetchPageClientsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.client.FetchPageClientsREQ,
                org.devolpex.backend.stubs.client.FetchPageClientsRES>(
                  this, METHODID_FETCH_PAGE_CLIENTS)))
          .addMethod(
            getCreateClientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.client.CreateClientREQ,
                org.devolpex.backend.stubs.client.ClientPRT>(
                  this, METHODID_CREATE_CLIENT)))
          .addMethod(
            getUpdateClientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.client.UpdateClientREQ,
                org.devolpex.backend.stubs.client.ClientPRT>(
                  this, METHODID_UPDATE_CLIENT)))
          .addMethod(
            getDeleteClientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.devolpex.backend.stubs.client.DeleteClientREQ,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_CLIENT)))
          .build();
    }
  }

  /**
   * <pre>
   * Services
   * </pre>
   */
  public static final class ClientServiceStub extends io.grpc.stub.AbstractStub<ClientServiceStub> {
    private ClientServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetchListClients(org.devolpex.backend.stubs.client.FetchListClientsREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.FetchListClientsRES> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchListClientsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fetchClientById(org.devolpex.backend.stubs.client.FetchClientByIdREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.FetchClientByIdRES> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchClientByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fetchPageClients(org.devolpex.backend.stubs.client.FetchPageClientsREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.FetchPageClientsRES> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchPageClientsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createClient(org.devolpex.backend.stubs.client.CreateClientREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.ClientPRT> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateClientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateClient(org.devolpex.backend.stubs.client.UpdateClientREQ request,
        io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.ClientPRT> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateClientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteClient(org.devolpex.backend.stubs.client.DeleteClientREQ request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteClientMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Services
   * </pre>
   */
  public static final class ClientServiceBlockingStub extends io.grpc.stub.AbstractStub<ClientServiceBlockingStub> {
    private ClientServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.devolpex.backend.stubs.client.FetchListClientsRES fetchListClients(org.devolpex.backend.stubs.client.FetchListClientsREQ request) {
      return blockingUnaryCall(
          getChannel(), getFetchListClientsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.devolpex.backend.stubs.client.FetchClientByIdRES fetchClientById(org.devolpex.backend.stubs.client.FetchClientByIdREQ request) {
      return blockingUnaryCall(
          getChannel(), getFetchClientByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.devolpex.backend.stubs.client.FetchPageClientsRES fetchPageClients(org.devolpex.backend.stubs.client.FetchPageClientsREQ request) {
      return blockingUnaryCall(
          getChannel(), getFetchPageClientsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.devolpex.backend.stubs.client.ClientPRT createClient(org.devolpex.backend.stubs.client.CreateClientREQ request) {
      return blockingUnaryCall(
          getChannel(), getCreateClientMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.devolpex.backend.stubs.client.ClientPRT updateClient(org.devolpex.backend.stubs.client.UpdateClientREQ request) {
      return blockingUnaryCall(
          getChannel(), getUpdateClientMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteClient(org.devolpex.backend.stubs.client.DeleteClientREQ request) {
      return blockingUnaryCall(
          getChannel(), getDeleteClientMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Services
   * </pre>
   */
  public static final class ClientServiceFutureStub extends io.grpc.stub.AbstractStub<ClientServiceFutureStub> {
    private ClientServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.client.FetchListClientsRES> fetchListClients(
        org.devolpex.backend.stubs.client.FetchListClientsREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchListClientsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.client.FetchClientByIdRES> fetchClientById(
        org.devolpex.backend.stubs.client.FetchClientByIdREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchClientByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.client.FetchPageClientsRES> fetchPageClients(
        org.devolpex.backend.stubs.client.FetchPageClientsREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchPageClientsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.client.ClientPRT> createClient(
        org.devolpex.backend.stubs.client.CreateClientREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateClientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.devolpex.backend.stubs.client.ClientPRT> updateClient(
        org.devolpex.backend.stubs.client.UpdateClientREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateClientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteClient(
        org.devolpex.backend.stubs.client.DeleteClientREQ request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteClientMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_LIST_CLIENTS = 0;
  private static final int METHODID_FETCH_CLIENT_BY_ID = 1;
  private static final int METHODID_FETCH_PAGE_CLIENTS = 2;
  private static final int METHODID_CREATE_CLIENT = 3;
  private static final int METHODID_UPDATE_CLIENT = 4;
  private static final int METHODID_DELETE_CLIENT = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_LIST_CLIENTS:
          serviceImpl.fetchListClients((org.devolpex.backend.stubs.client.FetchListClientsREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.FetchListClientsRES>) responseObserver);
          break;
        case METHODID_FETCH_CLIENT_BY_ID:
          serviceImpl.fetchClientById((org.devolpex.backend.stubs.client.FetchClientByIdREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.FetchClientByIdRES>) responseObserver);
          break;
        case METHODID_FETCH_PAGE_CLIENTS:
          serviceImpl.fetchPageClients((org.devolpex.backend.stubs.client.FetchPageClientsREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.FetchPageClientsRES>) responseObserver);
          break;
        case METHODID_CREATE_CLIENT:
          serviceImpl.createClient((org.devolpex.backend.stubs.client.CreateClientREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.ClientPRT>) responseObserver);
          break;
        case METHODID_UPDATE_CLIENT:
          serviceImpl.updateClient((org.devolpex.backend.stubs.client.UpdateClientREQ) request,
              (io.grpc.stub.StreamObserver<org.devolpex.backend.stubs.client.ClientPRT>) responseObserver);
          break;
        case METHODID_DELETE_CLIENT:
          serviceImpl.deleteClient((org.devolpex.backend.stubs.client.DeleteClientREQ) request,
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

  private static abstract class ClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.devolpex.backend.stubs.client.ClientOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientService");
    }
  }

  private static final class ClientServiceFileDescriptorSupplier
      extends ClientServiceBaseDescriptorSupplier {
    ClientServiceFileDescriptorSupplier() {}
  }

  private static final class ClientServiceMethodDescriptorSupplier
      extends ClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientServiceFileDescriptorSupplier())
              .addMethod(getFetchListClientsMethod())
              .addMethod(getFetchClientByIdMethod())
              .addMethod(getFetchPageClientsMethod())
              .addMethod(getCreateClientMethod())
              .addMethod(getUpdateClientMethod())
              .addMethod(getDeleteClientMethod())
              .build();
        }
      }
    }
    return result;
  }
}
