package top.choviwu.io.files.core.files.translator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import top.choviwu.io.files.core.annotation.Asserts;
import top.choviwu.io.files.core.annotation.FileStrategy;
import top.choviwu.io.files.core.annotation.TransForm;
import top.choviwu.io.files.core.convert.Convert;

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
@AllArgsConstructor
public abstract class DefaultFileStrategy<Param,Result> implements FileStrategy {

    private  File file;

    /**
     * 查看未知文件的后缀
     * @param file
     * @return
     */
    @Override
    public TYPE transFile(File file) {
        Asserts.isTrue(file!=null,"file is null");
        return Arrays.asList(FileStrategy.TYPE.values()).stream().filter(
                c->c.equals(file.getName().substring(file.getName().lastIndexOf(".")))).findFirst().orElse(TYPE.DEFAULT);
    }

    public abstract Result transform(Class<Param> param) throws Exception;

}
