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
 * @createTime : 2023/8/29 16:24
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
