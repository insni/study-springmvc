package io.springmvc.springmvcmaster;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomPropertyEditor extends PropertyEditorSupport {

      private final DateFormat dateFormat;
      private final boolean allowEmpty;

      // 생성자
      public CustomPropertyEditor(SimpleDateFormat dateFormat, boolean allowEmpty) {
            this.dateFormat = dateFormat;
            this.allowEmpty = allowEmpty;
      }

      @Override
      public void setAsText(String text) throws IllegalArgumentException {
            if (allowEmpty && (text == null || text.trim().isEmpty())) {
                  setValue(null); // 빈 문자열 처리
            } else {
                  try {
                        // 문자열을 Date 객체로 변환
                        setValue(dateFormat.parse(text));
                  } catch (ParseException e) {
                        throw new IllegalArgumentException("Could not parse date: " + text, e);
                  }
            }
      }

      @Override
      public String getAsText() {
            Date value = (Date) getValue();
            return (value != null ? dateFormat.format(value) : "");
      }
}