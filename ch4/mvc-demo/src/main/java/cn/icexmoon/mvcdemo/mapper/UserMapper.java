package cn.icexmoon.mvcdemo.mapper;

import cn.icexmoon.mvcdemo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.mapper
 * @ClassName : .java
 * @createTime : 2023/8/27 17:48
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface UserMapper {
    @Select("select * from tb_user where id=#{id}")
    User selectById(int id);

    void update(User user);

    @Delete("delete from tb_user where id=#{id}")
    void deleteById(int id);

    void insert(User user);
}
