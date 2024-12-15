package com.example.fuel_service.grpc;

import com.example.fuel_service.Services.FuelPriceService;
import com.example.proto.fuel.FuelProto;
import com.example.proto.fuel.FuelServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class FuelServiceImpl extends FuelServiceGrpc.FuelServiceImplBase {

    private final FuelPriceService fuelPriceService;

    public FuelServiceImpl(FuelPriceService fuelPriceService) {
        this.fuelPriceService = fuelPriceService;
    }

    @Override
    public void getFuelPrice(FuelProto.FuelPriceRequest request, StreamObserver<FuelProto.FuelPriceResponse> responseObserver) {
        String price = fuelPriceService.getFuelPriceByCountry(request.getCountry());
        FuelProto.FuelPriceResponse response = FuelProto.FuelPriceResponse.newBuilder()
                .setPrice(price)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


}