package cn.icexmoon.mvcdemo.mapper;

import cn.icexmoon.mvcdemo.config.SpringConfig;
import cn.icexmoon.mvcdemo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.mapper
 * @ClassName : .java
 * @createTime : 2023/8/29 11:19
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserMapperTests {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("icexmoon");
        user.setAddr("中国北京");
        user.setGender("男");
        user.setPassword("123");
        userMapper.insert(user);
        System.out.println(user);
        Assert.assertNotNull(user.getId());
    }
}
