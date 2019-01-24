package top.choviwu.io.files;

import org.junit.Test;
import top.choviwu.io.files.core.files.DocRead;
import top.choviwu.io.files.core.files.PdfRead;
import top.choviwu.io.files.core.files.translator.DefaultFileStrategy;
import top.choviwu.io.files.core.files.translator.DocFileStrategy;
import top.choviwu.io.files.core.files.translator.PDFFileStrategy;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public class TestDoc {

    public static void main(String[] args) throws Exception {
        File srcFile = new File("D:\\work\\demo.docx");
        File targetFile = new File("C:\\Users\\Administrator\\Desktop\\demo.docx");
        DefaultFileStrategy<DocRead,String> fileStrategy = new DocFileStrategy(srcFile);
        fileStrategy.transFile(new DocRead(),targetFile);
    }
}
