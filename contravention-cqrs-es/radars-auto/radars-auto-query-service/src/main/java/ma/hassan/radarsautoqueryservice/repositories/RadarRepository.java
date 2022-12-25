package ma.hassan.radarsautoqueryservice.repositories;

import ma.hassan.radarsautoqueryservice.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar,String> {


}
