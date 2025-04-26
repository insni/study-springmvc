package io.springmvc.springmvcmaster.converter;

import io.springmvc.springmvcmaster.model.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringAccountConverter implements Converter<String, Account> {
    @Override
    public Account convert(String source) {
        return new Account(source);
    }
}
