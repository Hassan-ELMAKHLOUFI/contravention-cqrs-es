package ma.hassan.radarsautoqueryservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.hassan.coreapi.RadarStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Radar implements Serializable {

    @Id
    private String Id ;
    private  String name ;
    private double  longitude ;
    private double latitude ;
    private double altitude ;
    private  int maxSpeed ;
    private String  roadDesignation ;
    private RadarStatus radarStatus ;
    @OneToMany(mappedBy = "radar")
    @JsonIgnore
    List<OverSpeedDetection> overSpeedDetections = new ArrayList<>();
}
