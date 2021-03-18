package com.example.oright.controller;

import com.alibaba.fastjson.JSON;
import com.example.oright.bean.*;
import com.example.oright.dao.*;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    PassageDao pd;
    @Autowired
    AuthorDao ad;
    @Autowired
    FavouriteDao fd;
    @Autowired
    FirmDao firmd;
    @Autowired
    ConcernDao cd;
    @Autowired
    Concern2Dao cd2;
    @Autowired
    UserDao ud;
    List<Passage> lp;
    List<Favourite> lf;
    List<Concern> lc;
    List<Concern2> lc2;
    List<Author> la;

    @RequestMapping("/addContent")
    public String addContent(@RequestBody Passage psg) throws UnsupportedEncodingException {
        String flag="error";
        String content=psg.getContent();
        //content= URLDecoder.decode(content, "utf-8");
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date); //2013-01-14
        int pid=0;
        int aid=ad.getIdByNamePwd(psg.getUsername(),psg.getPassword());
        lp=pd.getAllPsg();
        System.out.println("lp:"+lp);
        for(int i=0;i<lp.size();i++){
                Passage p=lp.get(i);
                if(p.getPid()>pid)
                    pid=p.getPid();

        }
        pid++;
        pd.insertContent(pid,aid,psg.getContent(),psg.getTitle(),time,psg.getType(),psg.getTheme());
        flag="success";
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("content",content);
        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    @RequestMapping("/deleteP")
    public String deleteP(@RequestBody Favourite f){
        String flag="error";
        System.out.println("f:"+f);

        pd.deleteP(f.getPid());
        flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        //res.put("content",content);
//        res.put("author",author);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/getPsg")
    public String getAllPsg(@RequestBody Favourite f)  {
        String flag="error";
        lp=pd.getAllPsg();
        //System.out.println("lp:"+lp);
        for(int i=0;i<lp.size();i++){
            Passage p=lp.get(i);
            //System.out.println("p:"+p);
            lp.get(i).setAuthor(ad.getNameById(p.getAid()));
        }
        int aid=ad.getIdByNamePwd(f.getUsername(),f.getPassword());
        lf=fd.getAllFByAid(aid);
        //System.out.println("lf:"+lf);
        lc=cd.getAllCByFansId(aid);
        for(int i=0;i<lc.size();i++){
            lc.get(i).setAuthor(ad.getNameById(lc.get(i).getAuthor_id()));
        }
        flag="success";
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("lp",lp);
        res.put("lf",lf);
        res.put("lc",lc);
        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;
    }

    @RequestMapping("/getPsgSearch")
    public String getAllPsgSearch(@RequestBody Favourite f)  {
        String flag="error";
        String content="%"+f.getContent()+"%";
        System.out.println("content:"+content);
        lp=pd.getAllPsgSearch(content);
        System.out.println("lpSearch:"+lp);
        for(int i=0;i<lp.size();i++){
            Passage p=lp.get(i);
            lp.get(i).setAuthor(ad.getNameById(p.getAid()));
        }
        int aid=ad.getIdByNamePwd(f.getUsername(),f.getPassword());
        lf=fd.getAllFByAid(aid);
        //System.out.println("lf:"+lf);
        lc=cd.getAllCByFansId(aid);
        for(int i=0;i<lc.size();i++){
            lc.get(i).setAuthor(ad.getNameById(lc.get(i).getAuthor_id()));
        }
        flag="success";
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("lp",lp);
        res.put("lf",lf);
        res.put("lc",lc);
        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;
    }

    @RequestMapping("/getPsgF")
    public String getAllPsgF(@RequestBody Favourite f)  {
        String flag="error";
        int aid=ad.getIdByNamePwd(f.getUsername(),f.getPassword());
        System.out.println("aid:"+aid);
        lf=fd.getAllFByAid(aid);
        //System.out.println("lf:"+lf);
        lp=pd.getAllPsg();
        System.out.println("lp:"+lp);
        boolean k;
        for(int i=lp.size()-1;i>=0;i--){
            //System.out.println("i:"+i);
            k=true;
            //Passage p=lp.get(i);
            //System.out.println("p:"+p);
            for(int j=0;j<lf.size();j++){
                if(lp.get(i).getPid()==lf.get(j).getPid())
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
        res.put("lf",lf);
        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/getFollow")
    public String getAllFollow(@RequestBody Favourite f)  {
        String flag="error";
        List<Author> la1 = new ArrayList<Author>();
        int fans_id=ad.getIdByNamePwd(f.getUsername(),f.getPassword());
        //System.out.println("fans_id:"+fans_id);
        lc=cd.getAllCByFansId(fans_id);
        //System.out.println("lc:"+lc);
        for(int i=lc.size()-1;i>=0;i--){
            int aid=lc.get(i).getAuthor_id();
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
    @RequestMapping("/getFans")
    public String getAllFans(@RequestBody Favourite f)  {
        String flag="error";
        List<Author> la1 = new ArrayList<Author>();
        List<Firm> lf1 = new ArrayList<Firm>();
        int author_id=ad.getIdByNamePwd(f.getUsername(),f.getPassword());
        //System.out.println("fans_id:"+fans_id);
        lc=cd.getAllCByAuthorId(author_id);
        //System.out.println("lc:"+lc);
        lc2=cd2.getAllCByAuthorId(author_id);
        System.out.println("lc2:"+lc2);
        for(int i=lc.size()-1;i>=0;i--){
            int fans_id=lc.get(i).getFans_id();
            Author a=ad.getAuthorById(fans_id);
            System.out.println("a:"+a);
            la1.add(a);
        }
        for(int i=lc2.size()-1;i>=0;i--){
            int fans_id=lc2.get(i).getFans_id();
            Firm firm=firmd.getFirmById(fans_id);
            System.out.println("f:"+firm);
            lf1.add(firm);
        }
        flag="success";
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("la",la1);
        res.put("lf",lf1);
        String res_json= JSON.toJSONString(res);
        //System.out.println("flag:"+flag);
        return res_json;
    }

    @RequestMapping("/getPsgP")
    public String getAllPsgP(@RequestBody Favourite f)  {
        String flag="error";
        int aid=ad.getIdByName(f.getUsername());
        System.out.println("aid:"+aid);
        lp=pd.getAllPsgByAid(aid);
        //System.out.println("lp:"+lp);

        lf=fd.getAllFByAid(aid);
        //System.out.println("lf:"+lf);
        for(int i=0;i<lp.size();i++){
            Passage p=lp.get(i);
            //System.out.println("p:"+p);
            lp.get(i).setAuthor(ad.getNameById(p.getAid()));

        }

        System.out.println("lp:"+lp);
        flag="success";
        HashMap<String,Object> res=new HashMap();
        res.put("flag",flag);
        res.put("lp",lp);
        res.put("lf",lf);
        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;
    }

    @RequestMapping("/addF")
    public String addF(@RequestBody Favourite f){
        String flag="error";
        System.out.println("f:"+f);


        int aid=ad.getIdByNamePwd(f.getUsername(),f.getPassword());
        System.out.println("aid:"+aid);

        lf=fd.getAllF();
        int fid=0;
        System.out.println("lf:"+lf);
        for(int i=0;i<lf.size();i++){
            Favourite ft=lf.get(i);
            //System.out.println("f:"+f);
            if(ft.getFid()>fid)
                fid=ft.getFid();

        }

        fid++;
        System.out.println("fid:"+fid);

        fd.insertF(fid,f.getPid(),aid);
        flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        //res.put("content",content);
//        res.put("author",author);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/deleteF")
    public String deleteF(@RequestBody Favourite f){
        String flag="error";
        System.out.println("f:"+f);


        int aid=ad.getIdByNamePwd(f.getUsername(),f.getPassword());
        System.out.println("aid:"+aid);


        int fid=fd.getFidByAidPid(f.getPid(),aid);
        System.out.println("fid:"+fid);
        fd.deleteF(fid);
        flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        //res.put("content",content);
//        res.put("author",author);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/addC")
    public String addC(@RequestBody Concern c){
        String flag="error";
        System.out.println("c:"+c);


        int aid=ad.getIdByName(c.getAuthor());
        System.out.println("aid:"+aid);

        int fid=ad.getIdByNamePwd(c.getUsername(),c.getPassword());

        lc=cd.getAllC();
        int cid=0;
        System.out.println("lc:"+lc);
        for(int i=0;i<lc.size();i++){
            Concern ct=lc.get(i);
            //System.out.println("ct:"+c);
            if(ct.getCid()>cid)
                cid=ct.getCid();

        }

        cid++;
        System.out.println("cid:"+cid);

        cd.insertC(cid,fid,aid);
        flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);


        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/deleteC")
    public String deleteC(@RequestBody Concern c){
        String flag="error";
        System.out.println("c:"+c);


        int aid=ad.getIdByName(c.getAuthor());
        System.out.println("aid:"+aid);


        int fid=ad.getIdByNamePwd(c.getUsername(),c.getPassword());
        System.out.println("fid:"+fid);
        cd.deleteC(fid,aid);
        flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        //res.put("content",content);
//        res.put("author",author);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/ainfo")
    public String authorInfo(@RequestBody Author a){
        String flag="error";
        System.out.println("a:"+a);

        Author author=ad.getAuthorByNamePwd(a.getUsername(),a.getPassword());

        flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("author",author);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    @RequestMapping("/updateAinfo")
    public String updateAinfo(@RequestBody Author a){
        String flag="error";
        System.out.println("a:"+a);

        ad.updateAuthor(a.getUsername(),a.getPassword(),a.getPhone(),a.getEmail());
        flag="success";

        return flag;

    }

    @RequestMapping("/updateApwd")
    public boolean updateApwd(@RequestBody HashMap<String,String> mpwd){

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

}
