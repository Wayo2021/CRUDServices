package crud.project.services.crudservices.bev_two.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private Integer points;
    private Set<RewardDTO> rewards;
}
