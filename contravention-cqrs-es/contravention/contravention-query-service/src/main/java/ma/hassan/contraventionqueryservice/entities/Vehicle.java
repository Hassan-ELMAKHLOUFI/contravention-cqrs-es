package ma.hassan.contraventionqueryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.hassan.coreapi.VehicleType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "vehicle")
    private List<Contravention> contraventionList = new ArrayList<>();
}
