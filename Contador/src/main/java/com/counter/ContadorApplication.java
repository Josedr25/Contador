package com.counter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ContadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContadorApplication.class, args);
	}

}

@RestController
class CounterController {
	private int counter = 0;
	
	@GetMapping("/counter")
	public String getCounter() {
		return "Counter: " + counter + "<br><a href=\"/reset\">Reset Counter</a>";
	}
	
	@GetMapping("/index")
	public String Index() {
		return "Hello, World!";
	}

	@GetMapping("/reset")
	public String resetCounter() {
		counter = 0;
		return "Counter reset to zero. <a href=\"/index\">Go to Home</a>";
	}
	
	@GetMapping("/*")
	public String any() {
		counter++;
		return "Hello, World!";
	}
}
