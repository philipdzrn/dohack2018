package dohack.ping;

import dohack.seeding.Seeding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
   @Autowired
   public Seeding seeding;
   
   @RequestMapping( value = "/ping")
   public String ping(){
      // seeding.seedData();
      
      return "ping";
   }

   @RequestMapping(value = "/asdf", method = RequestMethod.GET)
   public String test(@RequestHeader(value="currentUserId") String currentUserId) {
       return currentUserId;
   }
}
