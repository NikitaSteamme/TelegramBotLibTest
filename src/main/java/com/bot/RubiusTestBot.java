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
        return "";
    }

    @SneakyThrows
    @Override

    public void onUpdateReceived(Update update) {
        if (update.getMessage().getText().equals("/test")) {
            UserHelper userHelper = new UserHelper();                       // create helper for USER
            String answer = userHelper.getUserList().get(0).getUser_name(); // Generating answer
            execute(SendMessage
                    .builder()
                    .chatId(String.valueOf(update.getMessage().getChatId()))
                    .text(answer)
                    .build());
        } else if (update.getMessage().getText().equals("/dice")){
            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(update.getMessage().getChatId()));
            message.setText(String.valueOf(Math.round(Math.random()*(6-0.500001+1)+0.500001)));
            execute(message);
        }
    }
}
