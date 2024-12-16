package com.example.toll_service.grpc;

import com.example.proto.toll.TollProto;
import com.example.proto.toll.TollServiceGrpc;
import io.grpc.stub.StreamObserver;
import com.example.toll_service.services.TollService;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TollServiceGRPC extends TollServiceGrpc.TollServiceImplBase {
    private final TollService tollService;

    public TollServiceGRPC(TollService tollService) {
        this.tollService = tollService;
    }

    @Override
    public void getTollPrice(TollProto.TollPriceRequest request, StreamObserver<TollProto.TollPriceResponse> responseObserver) {
        double tollPrice = tollService.getTollPriceForTrip(request.getFrom(), request.getTo());
        TollProto.TollPriceResponse response = TollProto.TollPriceResponse.newBuilder()
                .setPrice(tollPrice)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
