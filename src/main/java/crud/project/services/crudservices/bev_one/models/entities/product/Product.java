//package crud.project.services.crudservices.models.entities.product;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "product",
//uniqueConstraints = {@UniqueConstraint(columnNames = "productCode")})
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String productName;
//    private String productPrice;
//    private String productCode;
//    @ManyToOne
//    @JoinColumn(name = "productType_id")
//    private ProductType productType;
//
//}
