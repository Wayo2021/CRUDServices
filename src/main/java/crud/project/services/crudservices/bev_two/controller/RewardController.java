package crud.project.services.crudservices.bev_two.controller;

import crud.project.services.crudservices.bev_two.model.dto.RewardDTO;
import crud.project.services.crudservices.bev_two.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
    @Autowired
    private RewardService rewardService;

    @GetMapping
    public List<RewardDTO> getAllRewards() {
        return rewardService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RewardDTO> getRewardById(@PathVariable Long id) {
        return rewardService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RewardDTO createReward(@RequestBody RewardDTO rewardDTO) {
        return rewardService.save(rewardDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReward(@PathVariable Long id) {
        rewardService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
