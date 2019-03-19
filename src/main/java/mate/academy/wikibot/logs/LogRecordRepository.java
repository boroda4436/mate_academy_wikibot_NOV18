package mate.academy.wikibot.logs;

import org.springframework.data.repository.CrudRepository;

public interface LogRecordRepository extends CrudRepository<LogRecord, Long> {
}
