package top.choviwu.io.files.core.bean;

import lombok.Getter;
import lombok.Setter;
import top.choviwu.io.files.core.annotation.Sequence;

import java.io.Serializable;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description :
 */
@Setter
@Getter
public class User implements Serializable{

    @Sequence
    private String name;

    @Sequence(index = 1)
    private String age;
    @Sequence(index = 2)
    private String haha;
    @Sequence(index = 3)
    private String value;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", haha='" + haha + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
