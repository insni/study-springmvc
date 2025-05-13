package io.springmvc.springmvcmaster;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalDataBinder {
      @InitBinder
      public void initBinder(WebDataBinder webDataBinder){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            webDataBinder.registerCustomEditor(Date.class,new CustomPropertyEditor(simpleDateFormat,false));


      }
}
