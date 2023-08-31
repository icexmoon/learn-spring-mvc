package cn.icexmoon.mvcdemo.controller;

import cn.icexmoon.mvcdemo.entity.User;
import cn.icexmoon.mvcdemo.service.UserService;
import cn.icexmoon.mvcdemo.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.controller
 * @ClassName : .java
 * @createTime : 2023/8/27 16:17
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public WebResult<User> getUserInfo(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return WebResult.success(user);
    }

    @DeleteMapping("/{id}")
    public WebResult<Object> deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return WebResult.success();
    }

    @PostMapping
    public WebResult<Integer> addUser(@RequestBody User user){
        userService.save(user);
        return WebResult.success(user.getId());
    }

    @PutMapping("/{id}")
    public WebResult<Object> updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        user.setId(id);
        userService.update(user);
        return WebResult.success();
    }
}
