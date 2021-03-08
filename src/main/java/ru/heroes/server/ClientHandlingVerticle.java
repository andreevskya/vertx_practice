package ru.heroes.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.heroes.server.data.dtos.builders.CharacterMovementDtoBuilder;
import ru.heroes.server.data.entities.CharacterEntity;
import ru.heroes.server.data.entities.CharacterMovementEntity;
import ru.heroes.server.data.repositories.CharacterMovementRepository;
import ru.heroes.server.data.repositories.CharacterRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientHandlingVerticle extends AbstractVerticle {
    public static final int TICK_DURATION_MS = 1_000;
    private static final Logger logger = LoggerFactory.getLogger(ClientHandlingVerticle.class);


    private ServerWebSocket client;
    private List<CharacterMovementProvider> charactersMovementProviders = new ArrayList<>();

    public ClientHandlingVerticle(ServerWebSocket client, CharacterMovementRepository repo, CharacterRepository characterRepo) {
        this.client = client;
        this.client.closeHandler(c -> {
            try {
                stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        for (CharacterEntity c : characterRepo.findAll()) {
            charactersMovementProviders.add(new CharacterMovementProvider(c, repo));
        }
    }

    @Override
    public void start() throws Exception {
        super.start();
        vertx.setPeriodic(TICK_DURATION_MS, c -> {
            long startTime = System.currentTimeMillis();
            int emptyProviders = 0;
            for (CharacterMovementProvider movementProvider : charactersMovementProviders) {
                CharacterMovementEntity movement = movementProvider.getMovement();
                if (movement == null) {
                    ++emptyProviders;
                    continue;
                }
                client.writeFinalTextFrame(JsonObject.mapFrom(CharacterMovementDtoBuilder.create(movement)).toString());
            }
            if (emptyProviders == charactersMovementProviders.size()) {
                logger.info("Client \"{}\" has not more movements", client.remoteAddress());
            }
            long elapsed = System.currentTimeMillis();
            if(elapsed - startTime > 1000) {
                logger.warn("Can't keep up! Waypoint processing took {} ms, expected <= {} ms", elapsed - startTime, TICK_DURATION_MS);
            }
        });
    }

    @Override
    public void stop() throws Exception {
        client.close();
        super.stop();
    }
}
