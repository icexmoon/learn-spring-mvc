package cn.icexmoon.mvcdemo.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.entity
 * @ClassName : .java
 * @createTime : 2023/8/27 17:57
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String gender;
    private String addr;
}
