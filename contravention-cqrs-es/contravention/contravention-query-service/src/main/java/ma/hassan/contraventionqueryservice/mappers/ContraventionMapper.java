package ma.hassan.contraventionqueryservice.mappers;

import ma.hassan.contraventionqueryservice.entities.Vehicle;
import ma.hassan.coreapi.VehicleRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContraventionMapper {
    Vehicle vehicleDtoToVehicle(VehicleRequestDTO vehicleRequestDTO) ;

}
