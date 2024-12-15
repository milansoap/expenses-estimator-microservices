package com.example.expenseservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @GetMapping("/api/calculate-expenses")
    public double calculateExpenses(@RequestParam double distance) {
        // Create a gRPC channel to connect to fuel-service
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        // Create a gRPC stub for FuelService
        FuelServiceGrpc.FuelServiceBlockingStub fuelStub = FuelServiceGrpc.newBlockingStub(channel);

        // Call the FuelService's GetFuelCost method
        FuelResponse fuelResponse = fuelStub.getFuelCost(FuelRequest.newBuilder().setDistance(distance).build());

        // Shutdown the channel after use
        channel.shutdown();

        // Return the fuel cost as response
        return fuelResponse.getCost();
    }
}
