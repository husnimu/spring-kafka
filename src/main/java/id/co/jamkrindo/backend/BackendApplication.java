package id.co.jamkrindo.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("\n======================");
		System.out.println("Application is starting");
		System.out.println("======================\n");
	}

	// @Bean
	// CommandLineRunner commandLineRunner(KafkaTemplate<String, String>
	// kafkaTemplate) {
	// return args -> {
	// for (int i = 0; i < 100; i++) {
	// kafkaTemplate.send("topic", "Hello world " + i);
	// }
	// };
	// }
}
