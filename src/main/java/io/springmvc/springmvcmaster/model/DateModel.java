package io.springmvc.springmvcmaster.model;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;
import java.util.Date;

@Data
public class DateModel {
     @NotNull
      private Date date;


}
