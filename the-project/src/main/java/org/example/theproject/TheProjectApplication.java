package org.example.theproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TheProjectApplication {

  @Bean
  ApplicationListener<WebServerInitializedEvent> webServerInitializedEventApplicationListener(Environment environment) {
    return event -> {
      int port = event.getApplicationContext().getWebServer().getPort();
      System.out.printf("Server started in port %s\n", port);
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(TheProjectApplication.class, args);
  }
}
