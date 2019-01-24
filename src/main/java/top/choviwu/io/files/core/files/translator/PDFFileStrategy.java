package top.choviwu.io.files.core.files.translator;

import lombok.Data;
import top.choviwu.io.files.core.annotation.FileException;
import top.choviwu.io.files.core.annotation.FileStrategy;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.files.DefaultIExcel;
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
 * @see DocFileStrategy
 */
@Data
public class PDFFileStrategy<K> extends DefaultFileStrategy<K,Object> {

    private  File file;

    private Convert[] converts;

    public PDFFileStrategy(File file) {
        super(file);
        this.file = file;
    }

    public PDFFileStrategy(File file, Convert[] converts) {
        super(file);
        this.converts = converts;
        this.file = file;
    }

    @Override
    public Object transform(K param,Object ... obj) throws Exception {
        if(obj.length>0){
            if(obj[0] instanceof File && param instanceof TRead){
                synchronized (this) {
                    return (String) ((TRead) param).readFile(file, (File) obj[0], null);
                }
            }
        }
        throw new FileException();
    }
}
