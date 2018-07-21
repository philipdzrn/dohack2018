package dohack.newfeed.controller;

import dohack.newfeed.dto.NewFeedDTO;
import dohack.newfeed.service.NewFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewFeedController {
   
   @Autowired
   private NewFeedService newFeedService;
   
   /**
    * Return all new feed
    *
    * @return
    */
   @RequestMapping(value = "/newfeed", method = RequestMethod.GET)
   public ResponseEntity<List<NewFeedDTO>> getChallenges() {
      List<NewFeedDTO> newFeedDTOS = this.newFeedService.getAllNewFeeds();
      
      return new ResponseEntity(newFeedDTOS, HttpStatus.OK);
   }
   
}
