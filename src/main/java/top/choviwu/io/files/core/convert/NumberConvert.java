package top.choviwu.io.files.core.convert;

import org.springframework.util.StringUtils;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public class NumberConvert implements Convert<Object> {
    @Override
    public Object convert(Object obj) {
        if(StringUtils.isEmpty(obj)){
            return "";
        }
        if(obj instanceof Integer){
            //TODO convert integer...
        }

        return "";
    }
}
