package hello.jdbc.repository.ex;

public class MyDuplicateKeyException extends MyDBException{

    public MyDuplicateKeyException(Throwable cause) {
        super(cause);
    }
}
