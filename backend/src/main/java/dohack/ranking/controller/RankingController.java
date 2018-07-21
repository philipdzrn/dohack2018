package dohack.ranking.controller;

import dohack.ranking.dto.RankingDTO;
import dohack.ranking.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankingController {
   @Autowired
   private RankingService rankingService;
   
   /**
    * Return list of all users sorted by number finished challenges
    *
    * @return
    */
   @RequestMapping(value = "/ranking", method = RequestMethod.GET)
   public List<RankingDTO> getRanking() {
      
      return rankingService.createListRankingDTOs();
   }
}
