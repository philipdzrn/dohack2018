package dohack.ping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
   @RequestMapping( value = "/ping")
   public String ping(){
      return "ping";
   }
}
