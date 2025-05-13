package io.springmvc.springmvcmaster;

import jakarta.servlet.ServletException;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

@Component
public class CustomTomcatWebServerCustomizer
implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

      @Override
      public void customize(TomcatServletWebServerFactory factory) {
//            set user define page about http status 401
            factory.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED,"/error/401"));
//            set user define page about http status 404
            factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/error/404"));
//            set user define page about http status 500
            factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500"));
//            set user define page about exception
            factory.addErrorPages(new ErrorPage(ServletException.class,"/error/exception"));
      }
}
