package ma.hassan.vehiclequeryservice.repositories;

import ma.hassan.vehiclequeryservice.entities.Owner;
import ma.hassan.vehiclequeryservice.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,String> {
}
