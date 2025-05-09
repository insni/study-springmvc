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

import java.util.*;

@RestController
@RequiredArgsConstructor
public class MessageController {
      private final MessageSource messageSource;
      private final Map<String,String> messages = new HashMap<>();
      private final Map<String,String> bindingMessages = new HashMap<>();

      @PostMapping("/order")
      public Map<String, Object> addOrder(@ModelAttribute Order order,
                                          BindingResult bindingResult) {

            MessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();
            if (!StringUtils.hasText(order.getProductName())) {
                  String messageCode = "require.order.productName";
                  addProductNameMessages(order, messageCodesResolver, messageCode);
                  String[] args = {order.getProductName()};
                  bindingResult.addError(new FieldError(order.getClass().getSimpleName().toLowerCase(),
                              "productName", null, false, new String[]{messageCode}, args, ""));
                  bindingResult.getAllErrors().stream().forEach(e -> addBidingMessage(e.getCode(),args));

            }

            String[] args = {"100", "1000"};
            if (10000 < order.getPrice() || order.getPrice() < 100) {
                  String messageCode = "range.order.price";
                  addPriceNameMessages(order, messageCodesResolver, messageCode);

                  bindingResult.addError(
                              new FieldError(order.getClass().getSimpleName().toLowerCase(),
                                          "price", null, false,
                                          new String[]{messageCode},
                                          args, ""));

                  bindingResult.getAllErrors().stream().forEach(e -> addBidingMessage(e.getCode(),args));
            }

            return Map.of("bidingResultMessage", bindingMessages,
                        "message", messages);

      }

      private void addBidingMessage(String messageCode,String[] args){
            String message = messageSource.getMessage(messageCode,
                        args,
                        Locale.KOREA);
            this.bindingMessages.put(messageCode, message);
      }

      private void addPriceNameMessages(Order order, MessageCodesResolver messageCodesResolver, String messageCode) {

            String code = messageCodesResolver.resolveMessageCodes("range",order.getClass().getSimpleName().toLowerCase(),"price", Integer.class)[0];
            String message = messageSource.getMessage(code,
                        new String[]{"100", "1000"},
                        Locale.KOREA);

            this.messages.put(messageCode, message);
      }
      private void addProductNameMessages(Order order, MessageCodesResolver messageCodesResolver, String messageCode) {

           String code = messageCodesResolver.resolveMessageCodes("require", order.getClass().getSimpleName().toLowerCase(), "productName", String.class)[0];

            String message=
                        messageSource.getMessage(code,
                                    new String[]{order.getProductName()},
                                    Locale.KOREA);

            this.messages.put(messageCode, message);
      }


}
