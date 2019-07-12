package mate.academy.wikibot.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import mate.academy.wikibot.dto.output.StatisticDataResponseDto;
import mate.academy.wikibot.entities.LogRecord;
import mate.academy.wikibot.repository.LogRecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "statistic")
public class StatisticsController {
    private final LogRecordRepository recordRepository;

    @Autowired
    public StatisticsController(LogRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    /**
     * Get statics info by telegram user identifier.
     * @param chatId   telegram user identifier
     * @param dateFrom date range start
     * @param dateTo   date range stop
     * @param limit    pagination limit
     * @param offset   pagination offset
     * @return the @{@link StatisticDataResponseDto} data
     */
    @GetMapping
    public StatisticDataResponseDto getByChatId(
            @RequestParam("chatId") final Long chatId,
            @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom,
            @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTo,
            @RequestParam(value = "limit", defaultValue = "20", required = false) final int limit,
            @RequestParam(value = "offset", defaultValue = "0", required = false)
            final int offset) {
        Iterable<LogRecord> logRecords = recordRepository.findAllByChatIdAndDateBetween(
                chatId, dateFrom.atStartOfDay(), dateTo.atStartOfDay(),
                PageRequest.of(offset, limit));

        List<String> allRequests = StreamSupport.stream(logRecords.spliterator(), false)
                .map(LogRecord::getMessage).collect(Collectors.toList());

        return StatisticDataResponseDto.builder().chatId(chatId).requests(allRequests).build();
    }
}
