package top.choviwu.io.files.core.annotation;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public interface Closable<T> {
    /**
     * 通过关闭接口
     */
    void close(T t) throws Exception;
}
