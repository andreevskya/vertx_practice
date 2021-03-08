package ru.heroes.server;

import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

/**
 * Запускалка-стартовалка Vert.x сервера.
 */
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan("ru.heroes.server")
@SpringBootApplication
public class ServerApplication {
    @Autowired
    private ServerVerticle server;

    @PostConstruct
    public void onInitDone() {
        Vertx v = Vertx.vertx();
        v.deployVerticle(server);
    }
}
