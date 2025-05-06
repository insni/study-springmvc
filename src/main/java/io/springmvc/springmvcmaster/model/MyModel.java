package io.springmvc.springmvcmaster.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

//public class MyModel {
//      @DateTimeFormat(pattern = "yyyy-MM-dd")
//      private Date startDate;
//      @DateTimeFormat(pattern = "yyyy/MM/dd")
//      private Date endDate;
//}

@Getter @Setter
public class MyModel {
      @NumberFormat(style = NumberFormat.Style.CURRENCY)
      private BigDecimal price;
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      private LocalDate date;
}