package top.choviwu.io.files.core.files;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author ChoviWu
 * @date 2019/1/24
 * Description :
 */
public class DocRead implements TRead<String,Object>{


    /**
     * 实际参与的方法
     * @param srcFile     源文件
     * @param targetFile   目标文件
     * @throws Exception
     */
    @Override
    public String readFile(File srcFile, File targetFile, Object o) throws Exception{
        if(!targetFile.exists()){
            targetFile.createNewFile();
        }
        FileCopyUtils.copy(srcFile, targetFile);
        OPCPackage opcPackage = POIXMLDocument.openPackage(targetFile.getPath());
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
        String txt= extractor.getText();
        return txt;
    }



}
