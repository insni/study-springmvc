package io.springmvc.springmvcmaster;

import io.springmvc.springmvcmaster.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.FieldError;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MessageController2 {
      private final MessageSource messageSource;
      private final Map<String,String> bindingMessages = new HashMap<>();

      @PostMapping("/order2")
      public Map<String, Object> addOrder(@ModelAttribute Order order,
                                          BindingResult bindingResult) {

            MessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();
            if (!StringUtils.hasText(order.getProductName())) {
                  String messageCode = "require.order.productName";
                  String[] args = {order.getProductName()};
                  bindingResult.rejectValue( "productName", messageCode, "product name is required (reject value)" );
                  bindingResult.getAllErrors().stream().forEach(e -> this.bindingMessages.put(e.getCode(),e.getDefaultMessage()));

            }


            if (10000 < order.getPrice() || order.getPrice() < 100) {
                  String[] args = {"100", "1000"};
                  String messageCode = "range.order.price";

                  bindingResult.rejectValue( "price", messageCode,args, "price must be between  "+args[0]+" and "+args[1]+" (reject value)" );
                  bindingResult.getAllErrors().stream().forEach(e -> this.bindingMessages.put(e.getCode(),e.getDefaultMessage()));
            }

            return Map.of("rejectValue", bindingMessages);


      }


}
