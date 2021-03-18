package com.example.oright.controller;

import com.alibaba.fastjson.JSON;
import com.example.oright.bean.Author;
import com.example.oright.bean.Firm;
import com.example.oright.bean.User;
import com.example.oright.dao.AuthorDao;
import com.example.oright.dao.FirmDao;
import com.example.oright.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class RegisterController {
    private int id=0;
    @Autowired
    AuthorDao ad;
    @Autowired
    FirmDao fd;

    List<Author> la;
    List<Firm> lf;




    @RequestMapping("/register")
    public String register(@RequestBody Author author){
        String flag="error";
        //如果注册名重复，则返回错误
        la=ad.getAllA();
        for(int i=0;i<la.size();i++){
            Author a=la.get(i);
            if(a.getUsername().equals(author.getUsername())) {
                flag="errorName";
                HashMap<String,Object> res=new HashMap();
                res.put("flag",flag);
                res.put("author",author);
                String res_json= JSON.toJSONString(res);
                return res_json;
            }
        }
        String chkCode=SmsCtrl.code;
        if(chkCode.equals(author.getVcode())){
            la=ad.getAllA();
            for(int i=0;i<la.size();i++){
                Author a=la.get(i);
                if(a.getId()>id)
                    id=a.getId();
            }
            author.setStatu("1");
            flag="s";
            id++;
            ad.insertA(id,author.getUsername(),author.getPassword(),author.getEmail(),author.getPhone());
        }
        else{
            author.setStatu("0");
        }
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("author",author);
        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/registerFirm")
    public String registerFirm(@RequestBody Firm firm){
        String flag="error";

        //System.out.println("firm:"+firm);

        String chkCode=SmsCtrl.code;
        //System.out.println("code:"+chkCode);
        if(chkCode.equals(firm.getVcode())){
            lf=fd.getAllFirm();
            for(int i=0;i<lf.size();i++){
                Firm f=lf.get(i);
                if(f.getId()>id)
                    id=f.getId();

            }
            firm.setStatu("1");
            flag="s";
            id++;
            //System.out.println("id:"+id);
            fd.insertFirm(id,firm.getUsername(),firm.getPassword(),firm.getEmail(),firm.getPhone());
            //System.out.println("add successfully");

        }
        else{
            firm.setStatu("0");
        }


        HashMap<String,Object> res=new HashMap();


        res.put("flag",flag);
        res.put("firm",firm);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/sendCode")
    public String register(@RequestBody String phone){
        phone=phone.substring(0,11);
        System.out.println("phone:"+phone);
        String flag="s";
        return flag;
    }
}
