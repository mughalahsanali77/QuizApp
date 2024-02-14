package app.quiz.service.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"app.quiz.entities"})
@EnableJpaRepositories(basePackages = {"app.quiz.core.repository"})
@ComponentScan(basePackages = {"app.quiz.core.transformer","app.quiz.service.quiz","app.quiz.common.helper"})
@SpringBootApplication
public class QuizServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizServiceApplication.class, args);
    }

}
