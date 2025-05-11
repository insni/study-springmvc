package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class ExposeUrlParamRedirectCon {
      private final UserService userService;
      @PostMapping
      public String redirect(
                  @ModelAttribute("user") User user,
                  RedirectAttributes redirectAttributes)
      {

            User saved = userService.save(user);
//            url 파라미터 값 노출
            redirectAttributes.addAttribute("userId",user.getUserId());

//            url 파라미터 값 노출 X
            redirectAttributes.addFlashAttribute("userId",user.getUserId());
            return "redirect:/user/success";


      }

      @GetMapping("/success")
      @ResponseBody
      public Map<String, String> success(
                  @RequestParam("userId") String paramUserId,
                  Model model){
            String flashUserId = (String) model.getAttribute("userId");
            return Map.of("viewName","successPage",
                        "paramUserId", paramUserId,
                        "flashUserId", flashUserId== null ? "":flashUserId);
      }

}
