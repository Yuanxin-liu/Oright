package com.example.oright.controller;

import com.alibaba.fastjson.JSON;
import com.example.oright.bean.*;
import com.example.oright.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class FirmController {
    @Autowired
    PassageDao pd;
    @Autowired
    AuthorDao ad;
    @Autowired
    Favourite2Dao fd2;
    @Autowired
    Concern2Dao cd2;
    @Autowired
    UserDao ud;
    @Autowired
    FirmDao firmd;
    List<Passage> lp;
    List<Favourite2> lf2;
    List<Concern2> lc2;
    List<Author> la;
    List<Firm> l_firm;

    @RequestMapping("/getPsgFirm")
    public String getAllPsg(@RequestBody Favourite f)  {
        String flag="error";

        lp=pd.getAllPsg();
        //System.out.println("lp:"+lp);

        for(int i=0;i<lp.size();i++){
            Passage p=lp.get(i);
            //System.out.println("p:"+p);
            lp.get(i).setAuthor(ad.getNameById(p.getAid()));

        }

        //System.out.println("lp:"+lp);


        int firm_id=firmd.getFirmIdByName(f.getUsername());
        System.out.println("fid:"+firm_id);
        lf2=fd2.getAllFByAid(firm_id);
        System.out.println("lf:"+lf2);

        lc2=cd2.getAllCByFansId(firm_id);
        for(int i=0;i<lc2.size();i++){

            lc2.get(i).setAuthor(ad.getNameById(lc2.get(i).getAuthor_id()));

        }
        System.out.println("lc:"+lc2);

        flag="success";
        HashMap<String,Object> res=new HashMap();


        res.put("flag",flag);
        res.put("lp",lp);
        res.put("lf",lf2);
        res.put("lc",lc2);

        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/addFFirm")
    public String addF(@RequestBody Favourite f){
        String flag="error";
        System.out.println("f:"+f);


        int firm_id=firmd.getFirmIdByName(f.getUsername());
        System.out.println("fid:"+firm_id);

        lf2=fd2.getAllF();
        int fid=0;
        System.out.println("lf:"+lf2);
        for(int i=0;i<lf2.size();i++){
            Favourite2 ft=lf2.get(i);
            //System.out.println("f:"+f);
            if(ft.getFid()>fid)
                fid=ft.getFid();

        }

        fid++;
        System.out.println("fid:"+fid);

        fd2.insertF(fid,f.getPid(),firm_id);

        flag="success";
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/deleteFFirm")
    public String deleteF(@RequestBody Favourite f){
        String flag="error";
        System.out.println("f:"+f);


        int firm_id=firmd.getFirmIdByName(f.getUsername());
        System.out.println("fid:"+firm_id);


        int fid=fd2.getFidByAidPid(f.getPid(),firm_id);
        System.out.println("fid:"+fid);
        fd2.deleteF(fid);
        flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        //res.put("content",content);
//        res.put("author",author);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/addCFirm")
    public String addC(@RequestBody Concern c){
        String flag="error";
        System.out.println("c:"+c);


        int aid=ad.getIdByName(c.getAuthor());
        System.out.println("aid:"+aid);

        int fid=firmd.getFirmIdByName(c.getUsername());

        lc2=cd2.getAllC();
        int cid=0;
        System.out.println("lc:"+lc2);
        for(int i=0;i<lc2.size();i++){
            Concern2 ct=lc2.get(i);
            //System.out.println("ct:"+c);
            if(ct.getCid()>cid)
                cid=ct.getCid();

        }

        cid++;
        System.out.println("cid:"+cid);

        cd2.insertC(cid,fid,aid);
        flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);


        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/deleteCFirm")
    public String deleteC(@RequestBody Concern c){
        String flag="error";
        System.out.println("c:"+c);


        int aid=ad.getIdByName(c.getAuthor());
        System.out.println("aid:"+aid);


        int fid=firmd.getFirmIdByName(c.getUsername());
        System.out.println("fid:"+fid);
        cd2.deleteC(fid,aid);
        flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        //res.put("content",content);
//        res.put("author",author);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/getFollowFirm")
    public String getAllFollow(@RequestBody Favourite f)  {
        String flag="error";
        List<Author> la1 = new ArrayList<Author>();

        int fans_id=firmd.getFirmIdByName(f.getUsername());
        //System.out.println("fans_id:"+fans_id);
        lc2=cd2.getAllCByFansId(fans_id);
        //System.out.println("lc:"+lc);


        for(int i=lc2.size()-1;i>=0;i--){
            int aid=lc2.get(i).getAuthor_id();
            Author a=ad.getAuthorById(aid);
            System.out.println("a:"+a);
            la1.add(a);
        }
        //System.out.println("la:"+la1);

        flag="success";
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("la",la1);
        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;
    }

    @RequestMapping("/getPsgFFirm")
    public String getAllPsgF(@RequestBody Favourite f)  {
        String flag="error";

        int firm_id=firmd.getFirmIdByName(f.getUsername());
        System.out.println("fid:"+firm_id);
        lf2=fd2.getAllFByAid(firm_id);
        //System.out.println("lf:"+lf);

        lp=pd.getAllPsg();
        System.out.println("lp:"+lp);

        boolean k;
        for(int i=lp.size()-1;i>=0;i--){
            //System.out.println("i:"+i);
            k=true;
            //Passage p=lp.get(i);
            //System.out.println("p:"+p);
            for(int j=0;j<lf2.size();j++){
                if(lp.get(i).getPid()==lf2.get(j).getPid())
                    k=false;

            }
            //System.out.println("k:"+k);
            if(k)
                lp.remove(i);
        }

        for(int i=0;i<lp.size();i++){
            Passage p=lp.get(i);
            //System.out.println("p:"+p);
            lp.get(i).setAuthor(ad.getNameById(p.getAid()));

        }

        //System.out.println("lp:"+lp);



        flag="success";
        HashMap<String,Object> res=new HashMap();


        res.put("flag",flag);
        res.put("lp",lp);
        res.put("lf",lf2);


        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;

    }
    @RequestMapping("/finfo")
    public String authorInfo(@RequestBody Firm f){
        String flag="error";
        System.out.println("f:"+f);
        Firm firm=firmd.getFirmByName(f.getUsername());
        flag="success";
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("firm",firm);
        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;
    }

    @RequestMapping("/updateFinfo")
    public String updateFinfo(@RequestBody Firm f){
        String flag="error";
        System.out.println("f:"+f);
        firmd.updateFirm(f.getUsername(),f.getPassword(),f.getPhone(),f.getEmail());
        flag="success";
        return flag;
    }

    @RequestMapping("/updateFpwd")
    public boolean updateFpwd(@RequestBody HashMap<String,String> mpwd){
        
        System.out.println("mpwds:"+mpwd);

        String oldpass=mpwd.get("oldpass");
        String pass=mpwd.get("checkPass");
        String name=mpwd.get("username");

        System.out.println("oldpass"+oldpass);
        System.out.println("pass:"+pass);

        System.out.println("name:"+name);
        User u=ud.getUserByName(name);
        String cpass=u.getPassword();
        System.out.println("cpass:"+cpass);
        //判断输入密码是否正确
        if(!oldpass.equals(cpass)){
            return false;
        }
//        System.out.println("sjhm:"+sjhm);
        boolean flag=false;
        ud.updateUserpwd(name,pass);
        flag=true;
        return flag;
    }

    @RequestMapping("/getPsgSearchFirm")
    public String getAllPsgSearch(@RequestBody Favourite2 f)  {
        String flag="error";

        String content="%"+f.getContent()+"%";
        System.out.println("content:"+content);
        lp=pd.getAllPsgSearch(content);
        System.out.println("lpSearch:"+lp);

        for(int i=0;i<lp.size();i++){
            Passage p=lp.get(i);
            //System.out.println("p:"+p);
            lp.get(i).setAuthor(ad.getNameById(p.getAid()));

        }

        //System.out.println("lp:"+lp);


        int firm_id=firmd.getFirmIdByName(f.getUsername());
        //System.out.println("aid:"+aid);
        lf2=fd2.getAllFByAid(firm_id);
        //System.out.println("lf:"+lf);

        lc2=cd2.getAllCByFansId(firm_id);
        for(int i=0;i<lc2.size();i++){
            ;
            lc2.get(i).setAuthor(ad.getNameById(lc2.get(i).getAuthor_id()));

        }
        //System.out.println("lc:"+lc);

        flag="success";
        HashMap<String,Object> res=new HashMap();


        res.put("flag",flag);
        res.put("lp",lp);
        res.put("lf",lf2);
        res.put("lc",lc2);

        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;

    }
}
