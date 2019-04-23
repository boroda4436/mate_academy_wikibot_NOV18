package mate.academy.wikibot.repository;

import java.time.LocalDateTime;
import java.util.List;

import mate.academy.wikibot.entities.LogRecord;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRecordRepository extends JpaRepository<LogRecord, Long> {
    List<LogRecord> findAllByChatId(final Long chatId);

    List<LogRecord> findAllByChatIdAndDateBetween(final Long chatId, final LocalDateTime from,
                                                  final LocalDateTime to, Pageable pageable);
}
