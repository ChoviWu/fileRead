package top.choviwu.io.files.core.annotation;

import top.choviwu.io.files.core.convert.Convert;

import java.io.File;
import java.io.InputStream;

/**
 * @author ChoviWu
 * @date 2019/1/2
 * Description :
 */
public interface TransForm<Result,V> {

    Result transform(File file, Class<V> tClass, Convert[] converts, String filePattern) throws Exception;
}
