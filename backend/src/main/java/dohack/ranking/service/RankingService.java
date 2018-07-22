package dohack.ranking.service;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.service.ChallengeService;
import dohack.ranking.dto.RankingDTO;
import dohack.user.model.User;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RankingService {
    @Autowired
    private UserService userService;

    @Autowired
    private ChallengeService challengeService;

    /**
     * Get all challenges by a user
     *
     * @param user
     * @return
     */
    public List<ChallengeDTO> getAllChallengesByUser(User user) {

        return challengeService.getChallengeDTOsByUser(user.getId());
    }

    /**
     * Get number of finished challenges by a user
     *
     * @param user
     * @return
     */
    public int getNumbFinishedChallenges(User user) {
        // Get all challenges by user
        List<ChallengeDTO> challengeDTOS = getAllChallengesByUser(user);

        // Count how many finished challenges
        int counter = 0;
        for (ChallengeDTO challengeDTO : challengeDTOS) {
            if (challengeDTO.isFinished) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Return a ranking DTO object by a user
     *
     * @param user
     * @return
     */
    public RankingDTO createRankingDTO(User user) {
        int numbFinishedChallenges = getNumbFinishedChallenges(user);

        RankingDTO rankingDTO = new RankingDTO(user.getId(), user.getName(), numbFinishedChallenges);

        return rankingDTO;
    }

    /**
     * Return a list of all ranking DTOs
     *
     * @return
     */
    public List<RankingDTO> createListRankingDTOs() {
        List<User> users = userService.getAllUsers();

        List<RankingDTO> rankingDTOS = new ArrayList<>();

        for (User user : users) {
            rankingDTOS.add(createRankingDTO(user));
        }

        rankingDTOS.sort(Comparator.comparingInt(RankingDTO::getNumbFinishedChallenges).reversed());

        return rankingDTOS;
    }

}
