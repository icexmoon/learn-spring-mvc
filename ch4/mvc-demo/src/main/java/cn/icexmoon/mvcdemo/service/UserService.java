package cn.icexmoon.mvcdemo.service;

import cn.icexmoon.mvcdemo.entity.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.service
 * @ClassName : .java
 * @createTime : 2023/8/27 18:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface UserService {
    User getById(int id);

    void save(User user);

    void update(User user);

    void deleteById(int id);
}
