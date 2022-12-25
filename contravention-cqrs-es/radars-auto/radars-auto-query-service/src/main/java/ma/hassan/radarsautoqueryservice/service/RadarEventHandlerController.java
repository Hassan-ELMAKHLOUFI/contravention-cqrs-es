package ma.hassan.radarsautoqueryservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.hassan.coreapi.*;
import ma.hassan.radarsautoqueryservice.entities.OverSpeedDetection;
import ma.hassan.radarsautoqueryservice.entities.Radar;
import ma.hassan.radarsautoqueryservice.mappers.RadarMapper;
import ma.hassan.radarsautoqueryservice.repositories.OverSpeedDetectionRepository;
import ma.hassan.radarsautoqueryservice.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Service
public class RadarEventHandlerController {

    @Autowired
    private RadarRepository radarRepository;

    @Autowired
    private OverSpeedDetectionRepository overSpeedDetectionRepository;


    @Autowired
    private RadarMapper radarMapper ;

    public RadarEventHandlerController(RadarRepository radarRepository, OverSpeedDetectionRepository overSpeedDetectionRepository, RadarMapper radarMapper) {
        this.radarRepository = radarRepository;
        this.overSpeedDetectionRepository = overSpeedDetectionRepository;
        this.radarMapper = radarMapper;
    }

    @EventHandler
    public void  on(RadarCreatedEvent event, EventMessage<RadarCreatedEvent> eventMessage){
  //      System.out.println("*********************"+event.getPayload().getRadarId());
       Radar radar = radarMapper.fromRadarD(event.getPayload());
      radar.setId(event.getId());

        radarRepository.save(radar);

    }

    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery getAllRadarsQuery){
        return radarRepository.findAll() ;
    }

    @EventHandler
    public void  on(VehicleOverSpeedDetectedEvent event){
        OverSpeedDetection overSpeedDetection = new OverSpeedDetection();
        overSpeedDetection.setId(UUID.randomUUID().toString());
        overSpeedDetection.setVehicleSpeed(event.getPayload().getVehicleSpeed());
        overSpeedDetection.setRadar(radarRepository.getById(event.getPayload().getRadarId()));
        overSpeedDetection.setVehicleRegistrationNumber(event.getPayload().getVehicleRegistrationNumber());
        overSpeedDetection.setDate(new Date());
        overSpeedDetectionRepository.save(overSpeedDetection);
    }

    @EventHandler
    public void on(RadarStatusChangedEvent event){

        Radar radar=radarRepository.findById(event.getId())
                .orElseThrow(()->new RuntimeException("Radar not found"));
        radar.setRadarStatus(event.getPayload());
        radarRepository.save(radar);
    }
    @QueryHandler
    public List<OverSpeedDetection> on(GetOverSpeedsQuery getOverSpeedsQuery){
        return overSpeedDetectionRepository.findAll() ;
    }

    @QueryHandler
    public Radar on(GetRadarById getRadarById){
        Radar radar = radarRepository.findById(getRadarById.getRadarId()).get();
        return radar;
    }

    @QueryHandler
    public List<OverSpeedDetection> on(GetOverSpeedDetectionByRadar getOverSpeedDetectionByRadar){
        Radar radar = radarRepository.findById(getOverSpeedDetectionByRadar.getRadarId()).get();
        List<OverSpeedDetection> overSpeedDetection = overSpeedDetectionRepository.findByRadar(radar);
        return overSpeedDetection;
    }


}
