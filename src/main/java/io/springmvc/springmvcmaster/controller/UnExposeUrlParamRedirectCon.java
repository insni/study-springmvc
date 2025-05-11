package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Map;

@RequestMapping("/flash")
@RequiredArgsConstructor
@Controller
@Slf4j
public class UnExposeUrlParamRedirectCon {

      @PostMapping
      public String setFlashAttribute(RedirectAttributes redirectAttributes)
      {
            redirectAttributes.addFlashAttribute("flashMessage","this is my message once");
            return "redirect:/flash";
      }
      @GetMapping
      public  String getFlashAttribute(Model model){
//      2. 플래시 속성에서 메세지 가져와서 출력하자
            String flashMessage = (String) model.asMap().get("flashMessage");
            log.info("flashMessage : {}",flashMessage);
            return "redirect:/flash/again";
      }

//      3. 다시 요청하여 플래시 속성이 잘 유지되는지 확인하자
      @GetMapping("/again")
      @ResponseBody
      public Map<String, String> getSuccessFlashAgain(
                  Model model){
            String flashMessage = (String) model.asMap().get("flashMessage");
            return Map.of(
                        "flashMessage",flashMessage==null?"":flashMessage
                        );
      }

}

