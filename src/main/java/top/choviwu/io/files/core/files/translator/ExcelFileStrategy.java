package top.choviwu.io.files.core.files.translator;

import lombok.Data;
import top.choviwu.io.files.core.annotation.FileException;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.files.DefaultIExcel;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2019/1/2
 * Description : Doc transform
 * @see DefaultFileStrategy
 * @see PDFFileStrategy
 */
@Data
public class ExcelFileStrategy<K> extends DefaultFileStrategy<K,List<K>> {

    private  File file;

    private Convert[] converts;

    public ExcelFileStrategy(File file) {
        super(file);
    }

    public ExcelFileStrategy(File file,Convert[] converts) {
        super(file);
        this.converts = converts;
        this.file = file;
    }
    @Override
    public List<K> transform(K param,Object ...obj) throws IOException {
        return new DefaultIExcel().read(file,param.getClass(),converts);
    }

}
