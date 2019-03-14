package mate.academy.wikibot.exception;

public class MyException extends RuntimeException {

    public MyException(Exception e) {
        e.printStackTrace();
    }
}
