package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.DateModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/date/binder")
public class DateBinderController {

      @ResponseBody
      @GetMapping("/")
      public Map<String, String> index(HttpServletRequest request) {
            Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
            String success = flashMap != null ? (String) flashMap.get("success") : null;
            String error = flashMap != null ? (String) flashMap.get("error") : null;

            return Map.of(
                        "success", success != null ? success : "",
                        "error", error != null ? error : ""
            );
      }

      @InitBinder
      public void initBinder(WebDataBinder webDataBinder) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
      }

      @PostMapping("/submit")
      @ResponseBody
      public Map<String, String> submitDate(@Valid DateModel dateModel,
                                            BindingResult bindingResult,
                                            Map map) throws  MethodArgumentNotValidException {
            if (bindingResult.hasErrors())
                  throw new MethodArgumentNotValidException(null,bindingResult);
            return Map.of("message", "success");
      }
}
