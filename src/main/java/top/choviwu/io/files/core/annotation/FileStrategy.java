package top.choviwu.io.files.core.annotation;

import java.io.File;
import java.io.IOException;

/**
 * @author ChoviWu
 * @date 2019/1/2
 * Description : 文件转化策略接口  用于转化文件
 */
public interface FileStrategy<K,V> {


    V transFile(K param,Object ...obj) throws Exception;


}
