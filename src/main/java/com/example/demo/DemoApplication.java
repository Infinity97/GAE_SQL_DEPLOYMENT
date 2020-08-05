package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

// Add the controller.
@RestController
class HelloWorldController {
	@GetMapping("/")
	public String hello() {
		return "hello world is the bestkjllkjlkjlkjkl!";
	}
}

@RestController
class DistinctController {

	@Autowired
	private IShowDetailsRepo showDetailsRepo;

	@GetMapping("/addDetails")
	public String hello() {

		ShowDetails showDetails = new ShowDetails();
		showDetails.setName("Handle these things");
		showDetailsRepo.save(showDetails);
		List<ShowDetails> showDetailsList = showDetailsRepo.findAll();
		StringBuilder stringBuilder = new StringBuilder();
		for(ShowDetails details: showDetailsList){
			stringBuilder.append(details.toString()).append("\n");
		}
		return "successfully deployed on the Google app engine and saved in the table \n" + stringBuilder.toString();
	}

	@GetMapping("/hello")
	public String updatedHello(){
		return "updated Hello String on GCP";
	}

	@GetMapping("/ayush")
	public String ayush(){
		return "Yup this is my name";
	}
}
