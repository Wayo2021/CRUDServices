//package crud.project.services.crudservices.services.product.impl;
//
//import crud.project.services.crudservices.models.dto.product.ProductDto;
//import crud.project.services.crudservices.models.entities.product.Product;
//import crud.project.services.crudservices.models.entities.product.ProductType;
//import crud.project.services.crudservices.repositories.product.ProductRepository;
//import crud.project.services.crudservices.repositories.product.ProductTypeRepository;
//import crud.project.services.crudservices.services.product.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProductServiceImpl implements ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private ProductTypeRepository productTypeRepository;
//
//
//    private Product convertProductToObject(ProductDto productDto){
//        Product pro = new Product();
//        pro.setId(productDto.getId());
//        pro.setProductName(productDto.getProductName());
//        pro.setProductPrice(productDto.getProductPrice());
//        pro.setProductCode(productDto.getProductCode());
//        return pro;
//    }
//
//    @Override
//    public Optional<Product> getProductById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Product> getAllProducts() {
//        return List.of();
//    }
//
//    @Override
//    public Optional<Product> saveProduct(ProductDto productDto) {
//        try {
//            Product productConvert = convertProductToObject(productDto);
//
//            ProductType productTypes =  productTypeRepository.findByProductTypeCode(productDto.getProductTypeCode()).orElseGet(()->{
//                throw  new RuntimeException("Product type code not found");
//            });
//
//            productConvert.setProductType(productTypes);
//
//            Product productSaved = productRepository.save(productConvert);
//            return Optional.of(productSaved);
//        }catch (Exception ex){
//            throw new RuntimeException(ex.getMessage());
//        }
//    }
//
//    @Override
//    public Optional<Product> updateProduct(Product product, long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public void deleteProduct(long id) {
//
//    }
//}
