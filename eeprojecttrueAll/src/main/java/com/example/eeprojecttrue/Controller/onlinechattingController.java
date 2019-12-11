package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class onlinechattingController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/chattingLogin")
    public ModelAndView index(@RequestParam("userId")String userId, @RequestParam("password")String password, HttpServletRequest request) throws UnknownHostException {
        //原本是userid  现在改动成了customer email
        //调取数据
        //这里进行数据库的验证 登陆账号登陆
        String username="匿名用户";//初始化成匿名用户
        if (StringUtils.isEmpty(userId))
        {
            System.out.println("这里是测试是否存在用户:"+userId);
            userId = "无";
        }
        else
        {
            //原本是userid  现在改动成了customer email
            Customer usertemple=customerService.findByEmail(userId);//这里的userid是email
            //System.out.println("这里是测试显示用户："+usertemple.toString());
            if(usertemple==null)
            {
                System.out.println("没有此用户");
            }
            else {
                if(!usertemple.getPassword().equals(password))
                {
                    System.out.println("密码验证错误");
                    ModelAndView mav = new ModelAndView("/index");
                    return mav;
                }
                else
                {
                    username=usertemple.getName();
                    userId=usertemple.getEmail();//这里的emai改动成了 其中的user id
                }
            }
        }
        ModelAndView mav = new ModelAndView("/chat");
        mav.addObject("username", username);
        mav.addObject("userId",userId);
        mav.addObject("webSocketUrl", "ws://"+ InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/chat");
        return mav;
    }
}
