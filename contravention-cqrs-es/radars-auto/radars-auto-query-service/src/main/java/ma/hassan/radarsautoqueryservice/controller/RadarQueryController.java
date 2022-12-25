package ma.hassan.radarsautoqueryservice.controller;

import ma.hassan.coreapi.GetAllRadarsQuery;
import ma.hassan.coreapi.GetOverSpeedDetectionByRadar;
import ma.hassan.coreapi.GetRadarById;
import ma.hassan.radarsautoqueryservice.entities.OverSpeedDetection;
import ma.hassan.radarsautoqueryservice.entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/radars")
public class RadarQueryController {

    @Autowired
    public QueryGateway queryGateway ;


    @GetMapping
    public CompletableFuture<List<Radar>> radarList(){
        return  queryGateway.query(new GetAllRadarsQuery(), ResponseTypes.multipleInstancesOf(Radar.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Radar> radar(@PathVariable String id ){
        return  queryGateway.query(new GetRadarById(id), ResponseTypes.instanceOf(Radar.class));
    }

    @GetMapping("/speed/{id}")
    public CompletableFuture<List<OverSpeedDetection>> overSpeedByRadar(@PathVariable String id ){
        return  queryGateway.query(new GetOverSpeedDetectionByRadar(id), ResponseTypes.multipleInstancesOf(OverSpeedDetection.class));
    }
}
