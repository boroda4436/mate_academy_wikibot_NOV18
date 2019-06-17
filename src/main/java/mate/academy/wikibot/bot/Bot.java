package mate.academy.wikibot.bot;

import com.google.api.services.youtube.model.SearchResult;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import mate.academy.wikibot.controllers.YouTubeRequestController;
import mate.academy.wikibot.dto.input.YouTubeRequestDto;
import mate.academy.wikibot.entities.LogRecord;
import mate.academy.wikibot.repository.LogRecordRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Telegram bot that send requests and take responses to/from telegram.
 */
@Log4j2
@Component
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;
    @Value("${youtube.Api.Key}")
    private String youtubeApiKey;

    private final YouTubeRequestController youTubeRequestController;
    private final LogRecordRepository logRecordRepository;

    /**
     * This Bot sends video from youTube.
     */
    public Bot(YouTubeRequestController contr,
               LogRecordRepository log) {
        this.youTubeRequestController = contr;
        this.logRecordRepository = log;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log(update);
        String message = update.getMessage().getText();
        YouTubeRequestDto youTubeRequestDto = new YouTubeRequestDto();
        youTubeRequestDto.setApiKey(youtubeApiKey);
        youTubeRequestDto.setMaxResults(10);
        youTubeRequestDto.setQuery(message);
        youTubeRequestDto.setTopicId(message);
        List<SearchResult> listOfVideo = null;

        try {
            listOfVideo = youTubeRequestController.getListOfVideo(youTubeRequestDto);
        } catch (IOException e) {
            log.error("Can't fetch the list of video. Request: {}.", youTubeRequestDto);
            sendMsg(update.getMessage().getChatId().toString(), "Ooops:( Something went wrong. "
                    + "We can't find video with " + message + " keyword");
        }
        if (listOfVideo != null) {
            for (SearchResult searchResult : listOfVideo) {
                sendMsg(update.getMessage().getChatId().toString(), String.format(
                        "https://www.youtube.com/watch?v=%s",searchResult.getId().getVideoId()));
            }
        }
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
            s = "Hello! Let's find the 10 random video! Please: enter a random word... "
                    + "Or feel free to ask some /help";
        }
        SendMessage sendMessage = new SendMessage();
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
                .date(LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(update.getMessage().getDate() * 1000L),
                        ZoneId.systemDefault()))
                .build();

        logRecordRepository.save(logRecord);
    }
}
