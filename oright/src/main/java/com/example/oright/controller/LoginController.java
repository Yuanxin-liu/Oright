package com.example.oright.controller;


import com.example.oright.bean.User;
import com.example.oright.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
@RestController
public class LoginController {

    @Autowired
    UserDao ud;




    @RequestMapping("/login")
    public String test(@RequestBody User user){
        String flag="error";
        System.out.println("user:"+user);
        String dRole="";
        if(user.getRole().equals("我要创作"))
            dRole="a";
        if(user.getRole().equals("我要素材"))
            dRole="f";
        System.out.println("dRole:"+dRole);
        //根据用户输入的用户名查询数据库的该用户名对应的信息（密码，角色）
        User us=ud.getUserByNameRole(user.getUsername(),dRole);
        System.out.println("us:"+us);
        //用户输入的密码
       String checkPass=us.getPassword();
        //如果密码正确可登陆到相应页面，否则返回错误
        if(checkPass.equals(user.getPassword())){
            //获得该用户的角色
            flag=us.getRole();
        }
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("user",us);
        String res_json=JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;
    }
}
