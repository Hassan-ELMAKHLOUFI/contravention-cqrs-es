package ma.hassan.contraventionqueryservice.repositories;

import ma.hassan.contraventionqueryservice.entities.Owner;
import ma.hassan.contraventionqueryservice.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,String> {

}
