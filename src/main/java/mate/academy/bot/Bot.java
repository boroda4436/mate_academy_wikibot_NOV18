package mate.academy.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@ComponentScan
@Component
public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public synchronized void sendMsg(String chatId, String s) {
        if (s.equals("/start")) {
            s = "Hello World";
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Value("${user.name}")
    private String userName;
    @Value("${telegram.token}")
    private String token;

    @Override
    public String getBotUsername() {
//        return "wiki_mate_academy_bot";
        return userName;
    }

    @Override
    public String getBotToken() {
//        return "536065274:AAEL-fRfzbXB5EM-FNsDutBLYvSDhQHWx10";
        return token;
    }

}
