package top.choviwu.io.files.core.files.translator;

import lombok.Data;
import top.choviwu.io.files.bean.User;
import top.choviwu.io.files.core.annotation.Asserts;
import top.choviwu.io.files.core.annotation.FileStrategy;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.files.excel.DefaultIExcel;
import top.choviwu.io.files.core.files.excel.UserExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2019/1/2
 * Description :
 */
@Data
public class ExcelFileStrategy<K> extends DefaultFileStrategy<K,List<K>> {

    private  File file;

    private Convert[] converts;

    public ExcelFileStrategy(File file) {
        super(file);
    }

    public ExcelFileStrategy(File file,Convert[] converts) {
        super(file);
        this.converts = converts;
        this.file = file;
    }


    @Override
    public List<K> transform(Class<K> k) throws Exception {
        transFile(file);
        return new DefaultIExcel().read(file,k.getClass(),converts);
    }

}
