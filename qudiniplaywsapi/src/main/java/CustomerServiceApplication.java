
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@SpringBootApplication(scanBasePackages = { "com.qudini" })
public class CustomerServiceApplication {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());

		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
