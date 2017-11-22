package algorithm.exception;

/**
 * Created by zjm on 22/11/2017.
 */
public class QueueEmptyException extends RuntimeException {

    /**
     * @param message 异常信息
     */
    public QueueEmptyException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public QueueEmptyException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message 异常信息
     * @param cause
     */
    public QueueEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
