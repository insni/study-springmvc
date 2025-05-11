package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Member;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {
      @PostMapping
      public Map<String, Object> addMember(@ModelAttribute @Valid Member member,
                                           BindingResult result,
                                           Map map)
      {
            Map<String, Object> body = new HashMap<>();

            Map<String, String> errorsMap = getErrorsMap(result);
            body.put("errorsMap",errorsMap);
            body.put("model",member);
            if (result.hasErrors())
                  body.put( "viewName","userForm");
            body.put( "viewName","userSuccess");
            return body;
      }
      private Map<String, String> getErrorsMap(BindingResult result) {
            Map<String, String> errorsMap = new HashMap<>();
            result.getAllErrors().forEach(error ->
                        errorsMap.put(error.getCode(), error.getDefaultMessage())
            );
            return errorsMap;
      }
}
