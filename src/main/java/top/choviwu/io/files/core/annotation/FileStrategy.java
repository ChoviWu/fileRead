package top.choviwu.io.files.core.annotation;

import java.io.File;

/**
 * @author ChoviWu
 * @date 2019/1/2
 * Description :
 */
public interface FileStrategy<T> {

    enum TYPE{
        DEFAULT("DEFAULT",0),
        EXCEL("EXCEL",1),
        PDF("PDF",2),
        WORD("WORD",3)
        ;
        TYPE(String type,Integer number){

        }

        TYPE() {
        }

    }

    TYPE transFile(File file);
}
