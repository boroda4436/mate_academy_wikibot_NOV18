package mate.academy.wikibot.bot;

import com.google.api.client.util.DateTime;
import mate.academy.wikibot.logs.LogRecordRepository;
import mate.academy.wikibot.logs.LogRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;
    @Autowired
    private LogRecordRepository logRecordRepository;

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        log(update);
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    private void sendMsg(String chatId, String s) {
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

    private void log(Update update) {
        LogRecord logRecord = LogRecord.builder()
                .message(update.getMessage().getText())
                .chatId(update.getMessage().getChatId())
                .date(new DateTime(update.getMessage().getDate() * 1000L))
                .build();

        logRecordRepository.save(logRecord);
    }
}
