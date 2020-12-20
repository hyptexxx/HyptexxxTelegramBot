package entity;

import config.DefaultConnectionConfig;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    private static final Logger LOGGER = Logger.getLogger(Bot.class);

    @Override
    public String getBotUsername() {
        return DefaultConnectionConfig.USERNAME;
    }

    @Override
    public String getBotToken() {
        return DefaultConnectionConfig.TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            Message message = update.getMessage();

            if(message.hasText()){
                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChatId().toString());
                sendMessageRequest.setText("you said: " + message.getText());

                try {
                    sendMessage(sendMessageRequest);
                } catch (TelegramApiException e) {
                    LOGGER.debug("some err");
                }
            }
        }

        LOGGER.debug("new Update recieve");
    }
}