package com.fanyank.controller;

import com.fanyank.dto.Message;
import com.fanyank.pojo.User;
import com.fanyank.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.apache.commons.codec.digest.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




/**
 * Created by yanfeng-mac on 2017/5/6.
 */
@Controller
public class UserController {
    @Value("${user.salt}")
    private String passwordSalt;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLoginCheck(Model model, String tel, String password, RedirectAttributes redirectAttributes) {
        //获取当前认证主体，如果当前主体已经存在，则退出当前主体
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }



        try{
            System.out.println("加密前password->" + password);
            System.out.println("密码盐+" + passwordSalt);


            System.out.println("tel->" + tel);
            System.out.println("加密后password->" + DigestUtils.md5Hex(password+passwordSalt));

            subject.login(new UsernamePasswordToken(tel,DigestUtils.md5Hex(password+passwordSalt)));

            System.out.println("tel->" + tel);
            System.out.println("password->" + DigestUtils.md5Hex(password+passwordSalt));

            Session session = subject.getSession();
            session.setAttribute(User.SESSION_KEY,(User)subject.getPrincipal());
            return "redirect:/home";
        } catch (LockedAccountException e){
            redirectAttributes.addFlashAttribute("message",new Message(Message.ERROR,e.getMessage()));
            return "redirect:/login";
        } catch (UnknownAccountException e) {
            redirectAttributes.addFlashAttribute("message",new Message(Message.ERROR,e.getMessage()));
            return "redirect:/login";
        } catch (AuthenticationException e) {
            redirectAttributes.addFlashAttribute("message",new Message(Message.ERROR,e.getMessage()));
            return "redirect:/login";
        }

    }
}
