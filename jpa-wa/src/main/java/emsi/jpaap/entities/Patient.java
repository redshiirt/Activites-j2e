package emsi.jpaap.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//entity and id for entity JPA
@Entity
//pour generate les constructors et les getters et setters
@Data @NoArgsConstructor
//JPA exige constructor sans parameter public
@AllArgsConstructor
public class Patient {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(length = 50)

    private String nom;
    @Temporal(TemporalType.DATE)
    private Date datenaissance;

    private Boolean malade;
    private int score ;
}
