package com.aos.oigo.controller.order;

import com.aos.oigo.pojo.ClassInfo;
import com.aos.oigo.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-20
 */
@Controller
public class ClassInfoController {
    @Autowired
    ClassInfoService classInfoService;

    @RequestMapping("/getclassinfo")
    public ModelAndView getClassInfo() {
        ModelAndView mv = new ModelAndView();
        List<ClassInfo> classInfo = classInfoService.selectClassInfo();
        classInfo.forEach(o -> {
            System.out.println(o);
        });
        mv.setViewName("classinfo");
        mv.addObject("info", classInfo);
        return mv;
    }
}
