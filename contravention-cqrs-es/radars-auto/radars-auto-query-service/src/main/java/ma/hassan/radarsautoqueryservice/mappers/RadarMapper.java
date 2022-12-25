package ma.hassan.radarsautoqueryservice.mappers;

import ma.hassan.coreapi.OverSpeedRequestDTO;
import ma.hassan.coreapi.OverSpeedResponseDTO;
import ma.hassan.coreapi.RadarDTO;
import ma.hassan.coreapi.RadarResponseDTO;
import ma.hassan.radarsautoqueryservice.entities.OverSpeedDetection;
import ma.hassan.radarsautoqueryservice.entities.Radar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RadarMapper {
    Radar fromRadarD(RadarDTO radarDTO) ;
    RadarDTO from (Radar radar);

    OverSpeedDetection from (OverSpeedRequestDTO overSpeedRequestDTO);

}
