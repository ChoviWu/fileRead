package top.choviwu.io.files.core.files.excel;

import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.utils.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description : 默认 Object
 */
public   class DefaultIExcel<T> implements IExcel<T> {

    @Override
    public List<T> read(File file, Class<T> objectClass) throws Exception {
        return null;
    }
    @Override
    public List<T> read(File file, Class<T> objectClass,
                        Convert[] converts) throws Exception {
        InputStream in = new FileInputStream(file);
        try {
            return ExcelUtils.getInstance().readExcel(in,file,objectClass,converts);
        }finally {
            in.close();
        }
    }

    @Override
    public void close(InputStream inputStream) throws IOException {
        if(inputStream!=null){
            inputStream.close();
        }
    }
}
