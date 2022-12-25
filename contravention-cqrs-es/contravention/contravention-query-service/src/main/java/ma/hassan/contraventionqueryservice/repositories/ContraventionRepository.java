package ma.hassan.contraventionqueryservice.repositories;

import ma.hassan.contraventionqueryservice.entities.Contravention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContraventionRepository extends JpaRepository<Contravention,String> {
}
