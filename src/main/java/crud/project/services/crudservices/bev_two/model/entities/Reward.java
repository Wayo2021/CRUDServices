package crud.project.services.crudservices.bev_two.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rewards")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer pointsRequired;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
