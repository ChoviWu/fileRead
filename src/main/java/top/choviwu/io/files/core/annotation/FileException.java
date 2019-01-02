package top.choviwu.io.files.core.annotation;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public class FileException extends RuntimeException{

    private String message;

    public FileException() {
    }

    public FileException(String message) {
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
