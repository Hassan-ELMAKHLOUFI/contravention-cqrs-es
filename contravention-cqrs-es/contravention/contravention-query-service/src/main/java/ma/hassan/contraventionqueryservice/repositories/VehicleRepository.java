package ma.hassan.contraventionqueryservice.repositories;

import ma.hassan.contraventionqueryservice.entities.Owner;
import ma.hassan.contraventionqueryservice.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {

    Vehicle findVehicleByRegistrationNumber(String register);
    List<Vehicle> findVehicleByOwner(Owner owner);
}
