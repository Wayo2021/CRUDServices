package crud.project.services.crudservices.bev_two.service;

import crud.project.services.crudservices.bev_two.model.entities.Reward;
import crud.project.services.crudservices.bev_two.model.dto.RewardDTO;
import crud.project.services.crudservices.bev_two.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RewardService {
    @Autowired
    private RewardRepository rewardRepository;

    public List<RewardDTO> findAll() {
        return rewardRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<RewardDTO> findById(Long id) {
        return rewardRepository.findById(id)
                .map(this::convertToDTO);
    }

    public RewardDTO save(RewardDTO rewardDTO) {
        Reward reward = convertToEntity(rewardDTO);
        Reward savedReward = rewardRepository.save(reward);
        return convertToDTO(savedReward);
    }

    public void deleteById(Long id) {
        rewardRepository.deleteById(id);
    }

    private RewardDTO convertToDTO(Reward reward) {
        RewardDTO dto = new RewardDTO();
        dto.setId(reward.getId());
        dto.setName(reward.getName());
        dto.setPointsRequired(reward.getPointsRequired());
        return dto;
    }

    private Reward convertToEntity(RewardDTO dto) {
        Reward reward = new Reward();
        reward.setId(dto.getId());
        reward.setName(dto.getName());
        reward.setPointsRequired(dto.getPointsRequired());
        return reward;

    }
}
