package com.yang.controller;

import com.yang.entity.Admin;
import com.yang.entity.User;
import com.yang.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/accountClient")
public class AccountClientHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session) {
        Object object = accountFeign.login(username, password, type);
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap) object;
        String result = null;
        String idStr = null;
        long id = 0L;
        //判断用户密码和账号
        if(object == null){
            //错误，返回重新登陆页面
            result = "login";
        }else {
            switch (type){
                case "user":
                    User user = new User();
                    idStr = hashMap.get("id") + "";
                    id = Long.parseLong(idStr);
                    String nickname = (String) hashMap.get("nickname");
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user", user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    idStr = hashMap.get("id") + "";
                    id = Long.parseLong(idStr);
                    String adminName = (String) hashMap.get("username");
                    admin.setId(id);
                    admin.setUsername(adminName);
                    session.setAttribute("admin", admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }
}
