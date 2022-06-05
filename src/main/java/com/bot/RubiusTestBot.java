package com.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class RubiusTestBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "RubiusTestBot";
    }

    @Override
    public String getBotToken() {
        return System.getenv("token");
    }

    @SneakyThrows
    @Override

    public void onUpdateReceived(Update update) {
        if (update.getMessage().getText().equals("/dice")){
            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(update.getMessage().getChatId()));
            message.setText(String.valueOf(Math.round(Math.random()*(6-0.500001+1)+0.500001)));
            execute(message);
        }
    }
}
