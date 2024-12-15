package com.example.expenses_service.services;

import com.example.proto.fuel.FuelServiceGrpc;
import com.example.proto.fuel.FuelProto.FuelPriceRequest;
import com.example.proto.fuel.FuelProto.FuelPriceResponse;
import org.springframework.stereotype.Service;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class ExpenseService {

    private final FuelServiceGrpc.FuelServiceBlockingStub fuelServiceClient;

    public ExpenseService() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051) // Replace with actual host/port
                .usePlaintext()
                .build();

        this.fuelServiceClient = FuelServiceGrpc.newBlockingStub(channel);
    }

    public double calculateExpenses(String country) {

        FuelPriceRequest request = FuelPriceRequest.newBuilder()
                .setCountry(country)
                .build();

        FuelPriceResponse response = fuelServiceClient.getFuelPrice(request);

        return Double.parseDouble(response.getPrice());

    }
}
