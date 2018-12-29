package top.choviwu.io.files.core.files.excel;

import top.choviwu.io.files.bean.User;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.utils.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public class UserExcel extends DefaultIExcel<User> {

    @Override
    public List<User> read(File file, Class<User> objectClass, Convert[] converts) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        try {
            return ExcelUtils.getInstance().readExcel(fis,file,objectClass,converts);
        }finally {
            this.close(fis);
        }
    }
}


