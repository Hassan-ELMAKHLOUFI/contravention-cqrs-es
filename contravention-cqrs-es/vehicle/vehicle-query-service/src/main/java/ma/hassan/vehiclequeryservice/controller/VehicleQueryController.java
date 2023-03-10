package ma.hassan.vehiclequeryservice.controller;

import ma.hassan.coreapi.GetAllVehiclesQuery;
import ma.hassan.vehiclequeryservice.entities.Owner;
import ma.hassan.vehiclequeryservice.entities.Vehicle;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/query/vehicle")
public class VehicleQueryController {

    @Autowired
    public QueryGateway queryGateway ;


    @GetMapping
    public CompletableFuture<List<Owner>> vehicleList(){
        System.out.println("******************************************");
        return  queryGateway.query(new GetAllVehiclesQuery(), ResponseTypes.multipleInstancesOf(Owner.class));
    }
}
