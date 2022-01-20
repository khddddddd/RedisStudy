package com.kehd.redisdemo.controller;

import com.kehd.redisdemo.service.IUserService;
import com.kehd.redisdemo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author kehd
 * @Date 2021-10-14 19:43
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/cachecontroller")
public class CacheController
{
    @Autowired
    IUserService userService;

    @GetMapping("/getuser")
    @ResponseBody
    public User getUser(int id) {
        return userService.getUser(id);
    }

    @PostMapping("/insertuser")
    @ResponseBody
    public User insertUser(String nickname, String password, String mobile, String role) {
        User user = new User();
        user.setNickname(nickname);
        user.setMobile(mobile);
        user.setRole(role);
        user.setPassword(password);
        userService.insertUser(user);
        return user;
    }

    @GetMapping("/finduser")
    @ResponseBody
    public List<User> findUsers(String nickname, String password) {
        return userService.findUsers(nickname, password);
    }

    @PostMapping("/updateuser")
    public String updateUser(int id, String nickname, String password, String role) {
        User user = userService.update(id, nickname, password, role);
        boolean flag = user != null;
        return flag ? "更新成功" : "更新失败";

    }

    @PostMapping("/deleteuser")
    public String deleteUser(int id){
        int result = userService.deleteUser(id);
        boolean flag = result == 1;
        return flag ? "删除成功" : "删除失败";
    }

}
