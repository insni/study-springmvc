package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Product;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

      @PostMapping
      public Map<String,Object> addProduct(
                  @Valid @ModelAttribute Product product,
                  BindingResult result,
                  Model model
                  ){

            Map<String, Object> response = new HashMap<>();

            // 에러가 존재할 경우
            if (result.hasErrors()) {
                  response.put("status", "error");
                  response.put("errors", result.getFieldErrors()); // 검증 실패 필드 정보를 반환
                  return response;
            }

            // 유효성 검사 통과 (정상 처리)
            response.put("status", "success");
            response.put("data", product); // 전달받은 Product 객체를 반환
            return response;

      }
}
