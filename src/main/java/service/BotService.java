package service;

import entity.Bot;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.generics.LongPollingBot;

import static config.DefaultConnectionConfig.RECONNECT_PAUSE;

public class BotService {
    private static final Logger LOGGER = Logger.getLogger(Bot.class);

     public <T extends LongPollingBot> void botConnect(T bot) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(bot);
            LOGGER.info("TelegramAPI started. Look for messages");
        } catch (TelegramApiRequestException e) {
            LOGGER.error("Cant Connect. Pause " + RECONNECT_PAUSE / 1000 + "sec and try again. Error: " + e.getMessage());

            try {
                Thread.sleep(RECONNECT_PAUSE);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
                return;
            }

            botConnect(bot);
        }
    }
}
