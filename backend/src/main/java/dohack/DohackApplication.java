package dohack;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class DohackApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DohackApplication.class, args);
	}

}