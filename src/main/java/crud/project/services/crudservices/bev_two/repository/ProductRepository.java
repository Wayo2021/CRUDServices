package crud.project.services.crudservices.bev_two.repository;

import crud.project.services.crudservices.bev_two.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
