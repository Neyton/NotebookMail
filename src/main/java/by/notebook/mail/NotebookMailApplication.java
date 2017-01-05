package by.notebook.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "by.notebook.mail.repository")
@EntityScan(basePackages = "by.notebook.mail/entity")
@ComponentScan(value = "by.notebook.mail")
public class NotebookMailApplication {

	public static void main(String[] args) {

		SpringApplication.run(NotebookMailApplication.class, args);

	}
}
