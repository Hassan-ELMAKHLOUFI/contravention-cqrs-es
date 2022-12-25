package ma.hassan.radarsautoqueryservice.repositories;

import ma.hassan.radarsautoqueryservice.entities.OverSpeedDetection;
import ma.hassan.radarsautoqueryservice.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OverSpeedDetectionRepository extends JpaRepository<ma.hassan.radarsautoqueryservice.entities.OverSpeedDetection,String> {

    List<OverSpeedDetection> findByRadar(Radar radar);
}
