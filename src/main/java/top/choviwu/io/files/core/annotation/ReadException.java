package top.choviwu.io.files.core.annotation;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public class ReadException extends RuntimeException{

    private String message;

    public ReadException() {
    }

    public ReadException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
