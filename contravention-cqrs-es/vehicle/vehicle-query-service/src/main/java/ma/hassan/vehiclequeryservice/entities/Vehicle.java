package ma.hassan.vehiclequeryservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.hassan.coreapi.VehicleType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    private String id;
    private String registrationNumber ;
    private VehicleType type;
    private String  brand ;
    private String model ;
    private int fiscalPower ;
    private String ownerName;


    @ManyToOne

    private Owner owner ;
}
