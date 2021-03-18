package com.example.oright.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
public class SmsCtrl {
    static String code;

    /**
     * 发送短信
     * @param phone
     * @return
     * @throws ClientException
     */
    @RequestMapping("/smsXxs")
    public Map<String,Object> smsXxs(@RequestBody String phone) throws ClientException {
        phone=phone.substring(0,11);
        Map<String,Object> map = new HashMap<>();
        // 验证码（指定长度的随机数）
        code = CodeUtil.generateVerifyCode(6);
        String TemplateParam = "{\"code\":\""+code+"\"}";
        // 短信模板id
        String TemplateCode = "SMS_197445055";
        SendSmsResponse response = SmsTool.sendSms(phone,TemplateParam,TemplateCode);
       // System.out.println("response:"+response);
        map.put("verifyCode",code);
        map.put("phone",phone);
        map.put("isOk","OK");

        return map;
    }
}

