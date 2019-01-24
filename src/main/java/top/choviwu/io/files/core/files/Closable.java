package top.choviwu.io.files.core.files;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public interface Closable {
    /**
     * 通道关闭接口
     * @param t  channel closed
     * @throws IOException
     */
    void close(Closeable t) throws IOException;
}
