package ma.hassan.contraventionqueryservice.service;

import lombok.AllArgsConstructor;
import ma.hassan.contraventionqueryservice.entities.Contravention;
import ma.hassan.contraventionqueryservice.entities.Owner;
import ma.hassan.contraventionqueryservice.entities.Vehicle;
import ma.hassan.contraventionqueryservice.mappers.ContraventionMapper;
import ma.hassan.contraventionqueryservice.repositories.ContraventionRepository;
import ma.hassan.contraventionqueryservice.repositories.OwnerRepository;
import ma.hassan.contraventionqueryservice.repositories.VehicleRepository;
import ma.hassan.coreapi.*;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ContraventionEventHandlerController {


    private VehicleRepository vehicleRepository ;
    private ContraventionMapper contraventionMapper ;
    private OwnerRepository ownerRepository;
    private ContraventionRepository contraventionRepository ;



    @EventHandler
    public void  on(VehicleCreatedEvent  event){
        System.out.println("*********************"+event.getPayload().getOwnerAddress());
        Vehicle vehicle = contraventionMapper.vehicleDtoToVehicle(event.getPayload());
        vehicle.setId(event.getId());
        Owner owner = new Owner() ;
        owner.setId(event.getId());
        owner.setOwnerAddress(event.getPayload().getOwnerAddress());
        owner.setOwnerEmail(event.getPayload().getOwnerEmail());
        owner.setOwnerName(event.getPayload().getOwnerName());
        owner.setOwnerNationalIdCard(event.getPayload().getOwnerNationalIdCard());
        owner.setOwnerPhoneNumber(event.getPayload().getOwnerPhoneNumber());
        Owner saved =ownerRepository.save(owner);
        vehicle.setOwner(saved);
        vehicleRepository.save(vehicle);



    }
    @EventHandler
    public void  on(VehicleOverSpeedDetectedEvent event){
        Contravention contravention = new Contravention();
        contravention.setContraventionId(UUID.randomUUID().toString());
        contravention.setAmount(700d);
        contravention.setStatus(ContraventionStatus.PENDING);

        contravention.setVehicle(vehicleRepository.findVehicleByRegistrationNumber(event.getPayload().getVehicleRegistrationNumber()));
        contraventionRepository.save(contravention);
    }


    @QueryHandler
    public List<Contravention> on(GetAllContraventions getAllVehiclesQuery){
         List<Contravention> list =contraventionRepository.findAll();
       return list;
    }

    @QueryHandler
    public Contravention on(GetContraventionById getContraventionById){

        return contraventionRepository.findById(getContraventionById.getContraventionId()).get();
    }

    @QueryHandler
    public List<Owner> on(GetAllOwners getAllOwners){

        return ownerRepository.findAll();
    }
    @QueryHandler
    public List<Contravention> on(GetContraventionByOwner getContraventionByOwner){
        List<Contravention> contraventionList = new ArrayList<>();

        List<Contravention> contraventions = contraventionRepository.findAll();


        for (int i = 0; i < contraventions.size(); i++) {
            if(contraventions.get(i).getVehicle().getOwner().getId() == getContraventionByOwner.getContraventionByOwner()){
                contraventionList.add(contraventions.get(i));
            }
        }
        return contraventionList ;
    }

    @QueryHandler
    public Owner on(GetOwnerById getOwnerById){

        return ownerRepository.findById(getOwnerById.getId()).get();
    }


}
