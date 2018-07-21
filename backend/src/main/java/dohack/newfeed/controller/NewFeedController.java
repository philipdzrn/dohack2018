package dohack.newfeed.controller;

import dohack.newfeed.service.NewFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewFeedController {

    @Autowired
    private NewFeedService newFeedService;


    //@RequestMapping( value = "/newfeed" )
    //public ResponseEntity<<List<NewFeedDTO>

}
