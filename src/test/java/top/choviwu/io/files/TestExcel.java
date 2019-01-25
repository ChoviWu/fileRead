package top.choviwu.io.files;

import org.junit.Test;
import top.choviwu.io.files.core.bean.User;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.convert.DefaultConvert;
import top.choviwu.io.files.core.files.translator.DefaultFileStrategy;
import top.choviwu.io.files.core.files.translator.ExcelFileStrategy;

import java.io.*;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public class TestExcel {

    @Test
    public void test3() throws Exception {
        File file = new File("C:\\Users\\Administrator\\Desktop\\demo.xls");
        DefaultFileStrategy<User,List> fileStrategy = new ExcelFileStrategy(file, new Convert[]{new DefaultConvert(),new DefaultConvert()});
        List<User> list = fileStrategy.transFile(new User());
        System.out.println(list);
    }
}
