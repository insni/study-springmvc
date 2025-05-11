package io.springmvc.springmvcmaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RequestMapping("/about/flash")
@Controller
public class AboutFlashController {

      @PostMapping
      public RedirectView setFlashAttribute(HttpServletRequest request,
                                            HttpServletResponse response){
            FlashMapManager flashMapManager= RequestContextUtils.getFlashMapManager(request);
            FlashMap outputFlashMap=RequestContextUtils.getOutputFlashMap(request);
            outputFlashMap.put("message","set flash random property!");

            if (flashMapManager != null) {
                  flashMapManager.saveOutputFlashMap(
                              outputFlashMap,request,response
                  );
            }
            return new RedirectView("/about/flash");

      }
      @GetMapping
      @ResponseBody
      public Map<String, ? extends Object> getFlashAttribute(HttpServletRequest request, Model model){
            Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
            if (inputFlashMap != null && inputFlashMap.size()!=0) {
                  String message = (String)inputFlashMap.get("message");
                  message=message==null?"":message;
                  return Map.of("message", message);
            }else {
                  return Map.of("message","no flash message!");
            }
      }


}
