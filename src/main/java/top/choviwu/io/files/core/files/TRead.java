package top.choviwu.io.files.core.files;

import java.io.File;

/**
 * @author ChoviWu
 * @date 2019/1/24
 * Description : File Read Interface
 * @see PdfRead
 * @see DocRead
 * @see ExcelRead
 */
public interface TRead<T,V> {

    /**
     * param 读取文件
     * @param srcFile     源文件
     * @param targetFile   目标文件
     * @param v       冗余参数
     * @return        return results
     */
    <T> T readFile(File srcFile,File targetFile,V v) throws Exception;
}
