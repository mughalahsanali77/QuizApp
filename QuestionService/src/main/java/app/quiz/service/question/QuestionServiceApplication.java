package app.quiz.service.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"app.quiz.entities"})
@EnableJpaRepositories(basePackages = {"app.quiz.core.repository"})
@ComponentScan(basePackages = {"app.quiz.core.transformer","app.quiz.service.question"})
@SpringBootApplication

public class QuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionServiceApplication.class, args);
    }

}
