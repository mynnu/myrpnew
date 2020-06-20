package org.spoto.controller;

import org.spoto.service.TeachService;
import org.spoto.utils.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudyController {
    
    @RequestMapping("read")
    @ResponseBody
    public String read(){

        TeachService ts = (TeachService) SpringUtils.getBean("teachService");
        String teach = ts.teach();
        System.out.println("Hi:" + teach);
        System.out.println("java真强大");
        String practise = ts.practise();
        System.out.println(practise);

        return "I want to read java";
    }


}
