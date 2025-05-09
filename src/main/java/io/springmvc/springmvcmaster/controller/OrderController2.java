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
public class OrderController2 {

      @PostMapping("/order2")
      public Map<String, String> saveOrder(@ModelAttribute("order") Order2 order,
                                           BindingResult bindingResult) {
            // 필드 오류 검증 (productName)
            if (!StringUtils.hasText(order.getProductName())) {
                  bindingResult.addError(new FieldError("order", "productName",
                              order.getProductName(), false, null, null, "상품명은 필수입니다."));
            }
            // 필드 오류 검증 (quantity)
            if (order.getQuantity() <= 0) {
                  bindingResult.addError(new FieldError("order", "quantity",
                             order.getQuantity(),false,null,null, "수량은 0보다 커야 합니다."));
            }
            if (order.getPrice() < 1_000_000 || order.getPrice() < 1) { // 가격 범위 제한 1 ~ 1,000,000
                  bindingResult.addError(new FieldError("order","price",order.getPrice(),
                              false,null,null,"1,000,000 이하여야 합니다."));
            }

            if (100 < order.getQuantity() || order.getPrice() < 1000) {
            bindingResult.addError(new ObjectError(
                        "order", "수량이 많을때는 가격이 1000 이상이여야 합니다."
            ));
            }



            // Map 형태로 반환
            Map<String, String> errorMap = new HashMap<>();
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
