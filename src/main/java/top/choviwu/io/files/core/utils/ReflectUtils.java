package top.choviwu.io.files.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import top.choviwu.io.files.core.FieldSequence;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.annotation.ReadException;
import top.choviwu.io.files.core.annotation.Sequence;

import java.lang.reflect.Field;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description : 反射获取数据并赋值返回
 */
public class ReflectUtils {

    private transient volatile Integer counter = 0;

    private static final Logger LOG = LoggerFactory.getLogger(ReflectUtils.class);

    public static <T> T getData(Class<T> tClass, Object object,
                                int number, T t, Convert[] convertList){
        Field[] fields = null;
        if(StringUtils.isEmpty(t)) {
            try {
                t = tClass.newInstance();
            } catch (InstantiationException e) {
                throw new ReadException("Reflect ERROR"+e);
            } catch (IllegalAccessException e) {
                throw new ReadException("Reflect ERROR"+e);
            }
        }

        fields = t.getClass().getDeclaredFields();
        //拿到字段的序号
        FieldSequence fieldSequence = new FieldSequence(null,null);
        for (Field field : fields) {
            //可见
            field.setAccessible(true);
            //扫描类上面的注解并进行顺序排列
            if (field.isAnnotationPresent(Sequence.class)) {
                Sequence sequence = field.getAnnotation(Sequence.class);
                int index = sequence.index();
                if(index==number){
                    fieldSequence = new FieldSequence(field,index);
                    break;
                }
            }
        }

        //排个序
        if(!StringUtils.isEmpty(fieldSequence.getField())) {
            //顺序
            Field field = fieldSequence.getField();
            try {
                field.set(t, fieldSequence.getIndex() >= convertList.length ? convertList[convertList.length - 1].convert(object) :
                        convertList[number].convert(object));
            } catch (IllegalAccessException e) {
                LOG.error(e.getMessage());
            }
        }
        return t;
    }
}
