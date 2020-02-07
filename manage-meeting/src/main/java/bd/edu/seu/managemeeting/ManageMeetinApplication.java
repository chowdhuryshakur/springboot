package bd.edu.seu.managemeeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ManageMeetinApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ManageMeetinApplication.class, args);

	}


}
