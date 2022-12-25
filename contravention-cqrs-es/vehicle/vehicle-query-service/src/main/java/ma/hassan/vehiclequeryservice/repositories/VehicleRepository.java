package ma.hassan.vehiclequeryservice.repositories;

import ma.hassan.vehiclequeryservice.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
}
