package top.choviwu.io.files.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
@Data
@AllArgsConstructor
public class FieldSequence {

    private Field field;

    private Integer index;

}
