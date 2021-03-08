package ru.heroes.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.heroes.server.data.repositories.CharacterMovementRepository;
import ru.heroes.server.data.repositories.CharacterRepository;

/**
 * Сервер приложения. Обслуживает клиентов, раздаёт статику.
 */
@Service
public class ServerVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(ServerVerticle.class);
    private static final int SERVER_PORT = 8080;

    @Autowired
    private CharacterMovementRepository movementRepo;

    @Autowired
    private CharacterRepository charRepo;

    @Override
    public void start() throws Exception {
        Router r = Router.router(vertx);
        r.route(HttpMethod.GET, "/*").handler(StaticHandler.create("static"));
        vertx.createHttpServer().requestHandler(r).webSocketHandler(clientSocket -> {
            logger.info("Client connected: {}", clientSocket.remoteAddress());
            ClientHandlingVerticle v = new ClientHandlingVerticle(clientSocket, movementRepo, charRepo);
            vertx.deployVerticle(v);
        }).listen(SERVER_PORT);
    }
}
