package top.choviwu.io.files.core.annotation;

import java.lang.annotation.*;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */

@Documented
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Sequence {

    int index() default 0;

}
