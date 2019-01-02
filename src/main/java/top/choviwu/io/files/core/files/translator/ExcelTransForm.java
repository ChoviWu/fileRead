package top.choviwu.io.files.core.files.translator;

import top.choviwu.io.files.bean.User;
import top.choviwu.io.files.core.annotation.FileException;
import top.choviwu.io.files.core.annotation.TransForm;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.files.excel.UserExcel;
import top.choviwu.io.files.core.utils.ExcelUtils;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2019/1/2
 * Description :
 */
public class ExcelTransForm implements TransForm<List<User>,User> {

    @Override
    public List<User> transform(File file, Class<User> tClass, Convert[] converts, String filePattern)  throws Exception{
        return new UserExcel().read(file,tClass,converts);
    }
}
