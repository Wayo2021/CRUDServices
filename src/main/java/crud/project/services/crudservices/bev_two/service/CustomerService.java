package crud.project.services.crudservices.bev_two.service;


import crud.project.services.crudservices.bev_two.model.entities.Customer;
import crud.project.services.crudservices.bev_two.model.entities.Reward;
import crud.project.services.crudservices.bev_two.model.dto.CustomerDTO;
import crud.project.services.crudservices.bev_two.model.dto.RewardDTO;
import crud.project.services.crudservices.bev_two.repository.CustomerRepository;
import crud.project.services.crudservices.bev_two.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RewardRepository rewardRepository;

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CustomerDTO> findById(Long id) {
        return customerRepository.findById(id)
                .map(this::convertToDTO);
    }

    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = convertToEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return convertToDTO(savedCustomer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public void addPoints(Long customerId, Integer points) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customer.setPoints(customer.getPoints() + points);
        customerRepository.save(customer);
    }

    public void redeemReward(Long customerId, Long rewardId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Reward reward = rewardRepository.findById(rewardId).orElseThrow();
        if (customer.getPoints() >= reward.getPointsRequired()) {
            customer.setPoints(customer.getPoints() - reward.getPointsRequired());
            reward.setCustomer(customer);
            customerRepository.save(customer);
            rewardRepository.save(reward);
        } else {
            throw new IllegalArgumentException("Not enough points to redeem this reward.");
        }
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPoints(customer.getPoints());
        dto.setRewards(customer.getRewards().stream()
                .map(this::convertRewardToDTO)
                .collect(Collectors.toSet()));
        return dto;
    }

    private Customer convertToEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPoints(dto.getPoints());
        return customer;
    }

    private RewardDTO convertRewardToDTO(Reward reward) {
        RewardDTO dto = new RewardDTO();
        dto.setId(reward.getId());
        dto.setName(reward.getName());
        dto.setPointsRequired(reward.getPointsRequired());
        return dto;
    }

    private Reward convertRewardToEntity(RewardDTO dto) {
        Reward reward = new Reward();
        reward.setId(dto.getId());
        reward.setName(dto.getName());
        reward.setPointsRequired(dto.getPointsRequired());
        return reward;

    }
}
