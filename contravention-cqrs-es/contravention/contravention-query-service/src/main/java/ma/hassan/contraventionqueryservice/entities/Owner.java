package ma.hassan.contraventionqueryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Owner {
    @Id
    private String id;
    private String ownerName ;
    private String ownerNationalIdCard;
    private String ownerEmail;
    private String ownerPhoneNumber;
    private String ownerAddress;
    @OneToMany(mappedBy = "owner" ,fetch = FetchType.LAZY)
     List<Vehicle> vehicle = new ArrayList<>();
}
