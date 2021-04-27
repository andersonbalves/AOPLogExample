package br.com.baratella.aoplogexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
@Slf4j
public class AopLogExampleApplication {

  public static void main(String[] args) {
    log.info("A aplicação foi iniciada: ");
    SpringApplication.run(AopLogExampleApplication.class, args);
  }

}
