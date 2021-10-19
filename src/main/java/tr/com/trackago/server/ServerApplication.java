package tr.com.trackago.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan( basePackages = {"tr.com.trackago.server.domain"} )
@ComponentScan(basePackages = {"tr.com.trackago"})
@EnableJpaRepositories(basePackages = {"tr.com.trackago.server.dao"})
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
