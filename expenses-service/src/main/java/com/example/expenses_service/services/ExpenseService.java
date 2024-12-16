package com.example.expenses_service.services;

import com.example.proto.fuel.FuelServiceGrpc;
import com.example.proto.fuel.FuelProto.FuelPriceRequest;
import com.example.proto.fuel.FuelProto.FuelPriceResponse;
import com.example.proto.toll.TollProto;
import com.example.proto.toll.TollProto.TollPriceRequest;
import com.example.proto.toll.TollProto.TollPriceResponse;
import com.example.proto.toll.TollServiceGrpc;
import org.springframework.stereotype.Service;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class ExpenseService {

    private final FuelServiceGrpc.FuelServiceBlockingStub fuelServiceClient;
    private final TollServiceGrpc.TollServiceBlockingStub tollServiceClient;

    public ExpenseService() {
        ManagedChannel fuelServiceChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        ManagedChannel tollServiceChannel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        this.fuelServiceClient = FuelServiceGrpc.newBlockingStub(fuelServiceChannel);
        this.tollServiceClient = TollServiceGrpc.newBlockingStub(tollServiceChannel);
    }

    public double calculateExpenses(String country) {

        FuelPriceRequest request = FuelPriceRequest.newBuilder()
                .setCountry(country)
                .build();

        FuelPriceResponse response = fuelServiceClient.getFuelPrice(request);

        return response.getPrice();

    }

    public double calculateTolls(String from, String to) {
        TollPriceRequest request = TollProto.TollPriceRequest.newBuilder().setFrom(from).setTo(to).build();
        TollPriceResponse response = tollServiceClient.getTollPrice(request);
        return response.getPrice();
    }
}
