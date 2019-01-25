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
    default void close(Closeable t) throws IOException{
        if(t!=null){
            t.close();
        }
    }
}
