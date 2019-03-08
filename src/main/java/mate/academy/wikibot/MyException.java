package mate.academy.wikibot;

public class MyException extends RuntimeException {

    public MyException(Exception e) {
        e.getMessage();
    }
}
