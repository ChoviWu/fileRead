package top.choviwu.io.files.core.convert;

import org.springframework.util.StringUtils;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
public class DefaultConvert implements Convert<Object> {
    @Override
    public Object convert(Object obj) {
        if(StringUtils.isEmpty(obj)){
            return "";
        }
        return obj;
    }
}
