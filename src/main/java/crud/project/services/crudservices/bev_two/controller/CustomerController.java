package crud.project.services.crudservices.bev_two.controller;

import crud.project.services.crudservices.bev_two.model.dto.CustomerDTO;
import crud.project.services.crudservices.bev_two.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return customerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{customerId}/points/{points}")
    public ResponseEntity<Void> addPoints(@PathVariable Long customerId, @PathVariable Integer points) {
        customerService.addPoints(customerId, points);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{customerId}/rewards/{rewardId}")
    public ResponseEntity<Void> redeemReward(@PathVariable Long customerId, @PathVariable Long rewardId) {
        try {
            customerService.redeemReward(customerId, rewardId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

    }
}