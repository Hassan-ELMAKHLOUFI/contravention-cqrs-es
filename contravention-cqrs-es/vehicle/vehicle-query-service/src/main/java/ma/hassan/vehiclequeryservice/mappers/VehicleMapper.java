package ma.hassan.vehiclequeryservice.mappers;

import ma.hassan.coreapi.VehicleRequestDTO;

import ma.hassan.vehiclequeryservice.entities.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle vehicleDtoToVehicle(VehicleRequestDTO vehicleRequestDTO) ;

}
