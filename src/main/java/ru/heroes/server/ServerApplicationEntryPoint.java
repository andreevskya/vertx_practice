package ru.heroes.server;

import org.springframework.boot.SpringApplication;

/**
 * Стартер.
 */
public class ServerApplicationEntryPoint {

    /**
     * Точка входа в приложение. Отсюда начинается выполнение.
     * @param args массив переданных аргументов.
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class);
    }
}
