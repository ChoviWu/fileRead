package top.choviwu.io.files.core.files;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import top.choviwu.io.files.core.annotation.Constants;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author ChoviWu
 * @date 2019/1/24
 * Description :
 */
public class PdfRead implements TRead<String,Object> ,Closable {

    /**
     * @param srcFile
     * @param targetFile
     * @throws Exception
     */
    @Override
    public String readFile(File srcFile,File targetFile,Object obj) throws Exception {
        // 是否排序
        boolean sort = false;
        // pdf文件名
        File pdfFile = srcFile;
        // 输入文本文件名称
        String textFile = null;
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
        int endPage = Integer.MAX_VALUE;
        // 文件输入流,生成文本文件
        Writer output = null;
        // 内存中存储的PDF Document
        PDDocument document = null;
        StringBuilder sb = new StringBuilder();
        try {
            String file = pdfFile.getPath();
            try {
                // 首先当作一个URL来装载文件,如果得到异常再从本地文件系统//去装载文件
                URL url = new URL(file);
                //注意参数已不是以前版本中的URL.而是File。
                document = PDDocument.load(pdfFile);
                // 获取PDF的文件名
                String fileName = url.getFile();
                // 以原来PDF的名称来命名新产生的txt文件
                if (fileName.length() > 4) {
                    targetFile = new File(fileName.substring(0, fileName
                            .length() - 4));
                }
            } catch (MalformedURLException e) {
                // 如果作为URL装载得到异常则从文件系统装载
                //注意参数已不是以前版本中的URL.而是File。
                document = PDDocument.load(pdfFile);
            }
            // 文件输入流,写入文件倒textFile
            output = new OutputStreamWriter(new FileOutputStream(targetFile),
                    Constants.UTF8);
            // PDFTextStripper来提取文本
            PDFTextStripper stripper = null;
            stripper = new PDFTextStripper();
            // 设置是否排序
            stripper.setSortByPosition(sort);
            // 设置起始页
            stripper.setStartPage(startPage);
            // 设置结束页
            stripper.setEndPage(endPage);
            // 调用PDFTextStripper的writeText提取并输出文本
            stripper.writeText(document, output);
            int chars;
            FileReader fileReader = new FileReader(targetFile);
            try {
                while ((chars = fileReader.read())!=-1){
                    sb.append((char) chars);
                }
            }finally {
                // 关闭输出流
                close(fileReader);
            }

        } finally {

            // 关闭输出流
            close(output);
            // 关闭PDF Document
            close(document);
        }
        return sb.toString();
    }

    @Override
    public void close(Closeable closeable) throws IOException {
        if(closeable!=null){
            closeable.close();
        }
    }

}
