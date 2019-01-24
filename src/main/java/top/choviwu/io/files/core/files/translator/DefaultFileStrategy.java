package top.choviwu.io.files.core.files.translator;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.choviwu.io.files.core.utils.AssertsUtils;
import top.choviwu.io.files.core.annotation.FileStrategy;

import java.io.File;

/**
 * @author ChoviWu
 * @date 2019/1/2
 * Description : 文件转化策略类
 */
@Data
@AllArgsConstructor
public abstract class DefaultFileStrategy<Param,Result> implements FileStrategy<Param,Result> {

    private  File file;

    /**
     * 查看未知文件的后缀
     * @return
     */
    @Override
    public Result transFile(Param param,Object ...obj) throws Exception {
        AssertsUtils.isTrue(file!=null,"file is null");
        return transform(param,obj);
    }

    protected abstract Result transform(Param param,Object ... obj) throws Exception;

}
