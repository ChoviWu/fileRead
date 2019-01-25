package top.choviwu.io.files.core.files;

import top.choviwu.io.files.core.convert.Convert;

import java.io.File;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public interface IFileType<T> extends Closable  {
    enum TYPE{
        EXCEL("EXCEL",1),
        PDF("PDF",2),
        WORD("WORD",3)
        ;
        TYPE(String type,Integer number){

        }

    }

    List<T> read(File file, Class<T> tClass, Convert[] converts) throws Exception;


}
