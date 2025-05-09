package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.Order;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class OrderController {
      @ModelAttribute
      public void getOrder(Model model) {
            model.addAttribute("order", new Order());
      }

      @PostMapping("/order")
      public Map<String, String> saveOrder(@ModelAttribute("order") Order order, BindingResult bindingResult) {
            // 필드 오류 검증 (productName)
            if (!StringUtils.hasText(order.getItem())) {
                  bindingResult.addError(new FieldError("order","item","상품명은 필수입니다."));
            }
            // 필드 오류 검증 (quantity)
            if (order.getQuantity() <= 0) {
                  bindingResult.addError(new FieldError("order", "quantity",
                              "수량은 0보다 커야 합니다."));
            }
            // 객체 수준 오류
            if (!StringUtils.hasText(order.getItem()) && (order.getQuantity() <= 0)) {
                  bindingResult.addError(new ObjectError("order",
                              "유효하지 않은 상품명입니다."));
            }

            // Map 형태로 반환
            Map<String, String> errorMap =new HashMap<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                  if (error instanceof FieldError fieldError) {
                        errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                  } else {
                        errorMap.put(error.getObjectName(), error.getDefaultMessage());
                  }
            }

            // 성공 시 message 반환
            if (errorMap.isEmpty()) {
                  errorMap.put("message", "주문이 성공적으로 저장되었습니다.");
            }

            return errorMap;
      }

}
