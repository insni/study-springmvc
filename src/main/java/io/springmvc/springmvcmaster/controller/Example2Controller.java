package io.springmvc.springmvcmaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.Map;

//spring version *.* ~ 2.5 (마이너 버전)
// run 하고 request 요청 해도 반응안함
public class Example2Controller implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/example2")
    public Map<String,String> get(){
        return Map.of("message", "Hello, World!");
    }


}
