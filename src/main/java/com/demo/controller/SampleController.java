package com.demo.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//Custom Model
import com.demo.model.UserModel;

//Load Config
@Configuration
@PropertySource("classpath:global.properties")

@Controller
@RequestMapping(value = "/sample")
public class SampleController {
    @Value("${global.code}")private String globalCode;

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView objMV = new ModelAndView();

        objMV.addObject("message", "sample");
        objMV.setViewName("/sample/index");

        return objMV;
    }

    @RequestMapping(value = "/getandpost", method = {RequestMethod.GET, RequestMethod.POST })
    public ModelAndView get(HttpServletRequest req, UserModel modelUser) throws Exception {
        String code = req.getParameter("code") != null ? req.getParameter("code") : globalCode;
        ModelAndView objMV = new ModelAndView();
        HttpSession objSession = req.getSession();
        
        objMV.addObject("code", code);
        
        if (code == "1") {
        } else {
            String name = req.getParameter("name") != null ? req.getParameter("name") : "",
                   passwd = req.getParameter("passwd") != null ? req.getParameter("passwd") : "";

            modelUser.setName(name);
            modelUser.setPasswd(passwd);
            objSession.setAttribute("name", name);
            objSession.setAttribute("passwd", passwd);
            objMV.addObject("name", name);
            objMV.addObject("passwd", passwd);
            objMV.addObject("modelUser", modelUser);
        }

        objMV.setViewName("/sample/getandpost");

        return objMV;
    }

    @RequestMapping(value = "/showmeagain")
    public ModelAndView showMeAgain(HttpServletRequest req) throws Exception {
        ModelAndView objMV = new ModelAndView();
        HttpSession objSession = req.getSession();

        objMV.addObject("name", objSession.getAttribute("name"));
        objMV.addObject("passwd", objSession.getAttribute("passwd"));

        objMV.setViewName("/sample/showmeagain");

        return objMV;
    }

    // load properites files
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}