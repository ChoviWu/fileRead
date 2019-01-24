package top.choviwu.io.files.core.files.translator;

import lombok.Data;
import top.choviwu.io.files.core.annotation.FileException;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.files.DefaultIExcel;
import top.choviwu.io.files.core.files.DocRead;
import top.choviwu.io.files.core.files.PdfRead;
import top.choviwu.io.files.core.files.TRead;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2019/1/2
 * Description : Doc transform
 * @see ExcelFileStrategy
 * @see PDFFileStrategy
 */
@Data
public class DocFileStrategy<K> extends DefaultFileStrategy<K,String > {

    private  File file;

    private Convert[] converts;

    public DocFileStrategy(File file) {
        super(file);
        this.file = file;
    }

    @Override
    public String transform(K param,Object ...obj) throws IOException {
        if(obj.length>0){
            if(obj[0] instanceof File && param instanceof TRead){
                synchronized (this) {
                    try {
                        return (String) ((TRead) param).readFile(file, (File) obj[0], null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        throw new FileException();
    }

}
