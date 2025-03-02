package crud.project.services.crudservices.bev_two.repository;

import crud.project.services.crudservices.bev_two.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
