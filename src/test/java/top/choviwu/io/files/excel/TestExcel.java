package top.choviwu.io.files.excel;

import org.junit.Test;
import top.choviwu.io.files.bean.User;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.convert.DefaultConvert;
import top.choviwu.io.files.core.files.excel.DefaultIExcel;
import top.choviwu.io.files.core.files.translator.ExcelFileStrategy;
import top.choviwu.io.files.core.utils.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static java.lang.System.in;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public class TestExcel {

    @Test
    public void test() throws FileNotFoundException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\2018122985375.xls");
        InputStream in = new FileInputStream(file);
        Convert[] converts = new Convert[]{new DefaultConvert(),new DefaultConvert()};
        System.out.println(ExcelUtils.getInstance().readExcel(in,file,User.class,converts));
    }
    @Test
    public void test2() throws Exception {
        File file = new File("C:\\Users\\Administrator\\Desktop\\zk集群配置修改.xls");
        System.out.println(new DefaultIExcel<User>().read(file,User.class, new Convert[]{new DefaultConvert(),new DefaultConvert()}));
    }
}
