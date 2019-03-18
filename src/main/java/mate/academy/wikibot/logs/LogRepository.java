package mate.academy.wikibot.logs;

import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Record, Long> {
}
