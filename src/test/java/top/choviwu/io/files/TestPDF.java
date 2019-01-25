package top.choviwu.io.files;

import org.junit.Test;
import top.choviwu.io.files.core.files.PdfRead;
import top.choviwu.io.files.core.files.translator.DefaultFileStrategy;
import top.choviwu.io.files.core.files.translator.PDFFileStrategy;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public class TestPDF {

    @Test
    public void test() throws FileNotFoundException {
        DefaultFileStrategy fileStrategy = new PDFFileStrategy(new File("C:\\Users\\Administrator\\Desktop\\阿里巴巴Java开发手册v1.2.0.pdf"));
        try {
            File targetFile = new File("C:\\Users\\Administrator\\Desktop\\阿里巴巴Java开发手册v1.2.0.docx");
            // 取得E盘下的SpringGuide.pdf的内容
            System.out.println(fileStrategy.transFile(PdfRead.PDF,targetFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
