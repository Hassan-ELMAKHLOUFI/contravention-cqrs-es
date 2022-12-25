package ma.hassan.contraventionqueryservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.hassan.coreapi.ContraventionStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contravention {

    @Id
    String  contraventionId;
    Double amount ;
    ContraventionStatus  status ;

    @ManyToOne
    @JsonIgnore
    Vehicle vehicle ;
}
