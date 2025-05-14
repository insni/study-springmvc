package io.springmvc.springmvcmaster;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource not found")
//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "error.resource")
public class ResourceNotFoundException extends RuntimeException {
}
