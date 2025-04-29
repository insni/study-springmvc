package io.springmvc.springmvcmaster;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.util.HashMap;

@RestController
@RequestMapping("/method")

public class MethodBasicParameterController {

    @GetMapping
    public HashMap<String, Object> webRequest(WebRequest webRequest,
                                              NativeWebRequest nativeWebRequest) {

        HashMap<String, Object> response = new HashMap<>();
        response.put("webRequestName", webRequest.getParameter("name"));
        response.put("userAgent", webRequest.getHeader("User-Agent"));

        HttpServletRequest nativeRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        Cookie[] cookies = nativeRequest.getCookies();
        response.put("cookies", cookies);
        return response;
    }

    @PostMapping("/session")
    public void session(HttpSession session) {
        session.setAttribute("user", "user");
    }

    @GetMapping("/session")
    public String getSession(HttpSession session) {
        String user = (String) session.getAttribute("user");
        return user;
    }

    @GetMapping("/user")
    public String getUserPrincipal(Principal principal) {
        return principal.getName();
    }

    @PostMapping("/check")
    public String handleHttpMethod(HttpMethod method) {
        if (method == HttpMethod.POST)
            return "post request is valid";

        return "post request not is valid";
    }


    @PostMapping("/readWrite")
    public void handleReader(Reader reader, Writer writer) throws IOException {
        char[] buffer = new char[1024];
        int bytesRead = reader.read(buffer);
        System.out.println("Read " + bytesRead + " bytes from the reader");
        writer.write("this is the response body");

    }


}
