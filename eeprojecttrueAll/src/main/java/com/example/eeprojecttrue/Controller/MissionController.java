package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.Mission;
import com.example.eeprojecttrue.Service.Cluster.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//这了是实现portfoliotwo的表单提交哦
@Controller
public class MissionController  {

    @Autowired
    private MissionService missionService;

    //这里写有关所有可以获取的任务的列表
    @RequestMapping(value = "/submitmission",method = RequestMethod.POST)
    public String SaveMission(@RequestParam("id")int id,@RequestParam("title")String title,@RequestParam("message")String message, HttpServletRequest request)
    {
        Mission newmission=new Mission();
        newmission.setTitle(title);
        newmission.setComment(message);
        newmission.setGid(id);
        HttpSession session=request.getSession();

        if(session==null)
        {
            return "redirect:/login";
        }
        else
        {
            if(missionService.Save(newmission))
            {
                return "portfoliotwo";
            }
        }
        return "/login";
    }
}