package top.choviwu.io.files.core.files;

import top.choviwu.io.files.core.convert.Convert;

import java.io.*;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description : 默认 Object
 */
public class DefaultIExcel<T> implements IFileType<T> {

    @Override
    public List<T> read(File file, Class<T> objectClass) throws IOException {
        return null;
    }
    @Override
    public List<T> read(File file, Class<T> objectClass,
                        Convert[] converts) throws IOException {
        InputStream in = new FileInputStream(file);
        try {
            return ExcelRead.getInstance().readExcel(in,file,objectClass,converts);
        }finally {
            in.close();
        }
    }

    @Override
    public void close(Closeable closeable) throws IOException {
        if(closeable!=null){
            closeable.close();
        }
    }
}
