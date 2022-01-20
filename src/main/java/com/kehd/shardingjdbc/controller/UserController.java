package com.kehd.shardingjdbc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kehd
 * @Date 2021-11-5 17:09
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/usercontroller")
public class UserController {

    @RequestMapping("/hello2")
    public String hello2() {
        return "Hello, World!";
    }

   /* @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user/save")
    @ResponseBody
    public String save() {
        for (int i = 0; i <10 ; i++) {
            User user=new User();
            user.setName("test"+i);
            user.setCityId(1%2==0?1:2);
            user.setCreateTime(new Date());
            user.setSex(i%2==0?1:2);
            user.setPhone("11111111"+i);
            user.setEmail("xxxxx");
            user.setCreateTime(new Date());
            user.setPassword("eeeeeeeeeeee");
            userMapper.save(user);
        }

        return "success";
    }

    @RequestMapping("/user/get/{id}")
    @ResponseBody
    public User get(@PathVariable Long id) {
        User user =  userMapper.get(id);
        System.out.println(user.getId());
        return user;
    }*/

}
